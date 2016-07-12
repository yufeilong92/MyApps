package com.example.myphotoservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/11.
 */
public class PhtotoService extends Service {
    private final static  String TAG="准备结果";
    private MediaRecorder recorder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        //[☆]获取telephonemanager的实例
        TelephonyManager systemService = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        //[☆]注册电话监听
        systemService.listen(new MyPhoneStateChangeed(),PhoneStateListener.LISTEN_CALL_STATE);

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
//    定义一个类监听电话状态
    private class MyPhoneStateChangeed extends PhoneStateListener{
        /**
         * 当电话设备发生改变时调用
         * @param state
         * @param incomingNumber
         */
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE://空闲状态
                    if(recorder!=null){
                        recorder.stop();//停止录音
                        recorder.reset();   // You can reuse the object by going back to setAudioSource() step
                        recorder.release();//释放资源
                    }
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK://接听状态
                    Log.i(TAG, "开始录音");
                    recorder.start();   // Recording is now started
                    break;
                case TelephonyManager.CALL_STATE_RINGING://电话响铃状态
                    Log.i(TAG, "准备一个录音机");
                    try {
                        recorder = new MediaRecorder();
                        //[☆]设置音频的来源
                        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        //[☆]设置输出的格式
                        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        //[☆]设置音频的编码格式
                        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        //[☆]设置存放的路径
                        recorder.setOutputFile("/mnt/sdcard/lutin.3gp");
                        //[☆]准备录
                        recorder.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            super.onCallStateChanged(state, incomingNumber);
        }
    }
}
