package com.example.myappregistreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/12.
 */
public class ScreenReceiver extends BroadcastReceiver {
    private final static String TAG="查询结果";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(action.equals("android.intent.action.SCREEN_ON")){
            Log.i(TAG, "解屛");
        }else if(action.equals("android.intent.action.SCREEN_OFF")){
            Log.i(TAG, "屏幕锁屏 ");
        }
    }
}
