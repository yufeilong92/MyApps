package com.example.myappregistreceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/7/12.
 */
public class ScreenService extends Service {

    private ScreenReceiver receiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
public void onCreate() {
    //[☆]创建ScreenRecicer
    receiver = new ScreenReceiver();
    IntentFilter filter = new IntentFilter();
    filter.addAction("android.intent.action.SCREEN_ON");
    filter.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(receiver,filter);
    super.onCreate();
}

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}
