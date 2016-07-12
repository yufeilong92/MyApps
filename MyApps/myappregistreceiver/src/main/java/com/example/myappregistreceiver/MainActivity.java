package com.example.myappregistreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        <receiver android:name=".ScreenReceiver">
//        <intent-filter>
//        <action android:name="android.intent.action.SCREEN_ON"/>
//        <action android:name="android.intent.action.SCREEN_OFF"/>
//        </intent-filter>
//        </
        Intent intent = new Intent();
        intent.setClass(this,ScreenService.class);
        startService(intent);

    }


}