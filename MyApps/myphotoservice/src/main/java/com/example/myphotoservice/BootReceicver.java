package com.example.myphotoservice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/7/12.
 */
public class BootReceicver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent();
        intent1.setClass(context,PhtotoService.class);
        context.startService(intent1);
    }
}
