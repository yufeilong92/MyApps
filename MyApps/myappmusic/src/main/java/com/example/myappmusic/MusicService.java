package com.example.myappmusic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/12.
 */
public class MusicService extends Service {
    private final static String TAG="查询结果";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Mybinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    public  void playMusic(){

        Log.i(TAG, "playMusic播放了 ");
    }
    public  void pauseMusic(){

        Log.i(TAG, "playMusic:音乐暂停 ");
    }
    public  void replayMusic(){


        Log.i(TAG, "playMusic: 音乐继续");
    }
//定义dinder对象
    protected class Mybinder extends Binder implements Iserivce{

        @Override
        public void CallPlayMUsic() {
            playMusic();
        }

        @Override
        public void CallPauseMUsic() {
            pauseMusic();
        }

        @Override
        public void CallReplsyUsic() {
            replayMusic();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
