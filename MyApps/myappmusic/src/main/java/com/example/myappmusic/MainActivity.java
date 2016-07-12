package com.example.myappmusic;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Iserivce mybinder;
    private Myconn myconn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //[☆]混合方式开启服务
        //[☆]先调startservice目的保证服务能在后台长期服务
        Intent intent = new Intent(this, MusicService.class);
        startService(intent);
        myconn = new Myconn();
        bindService(intent, myconn,BIND_AUTO_CREATE);

    }

    //点击按钮播放音乐
    public void click(View v) {
        mybinder.CallPlayMUsic();
    }

    //点击按钮暂停播放
    public void click1(View v) {
        mybinder.CallPauseMUsic();
    }

    //点击按钮继承播放
    public void click4(View v) {
        mybinder.CallReplsyUsic();
    }

    //    定义连接对象
    private class Myconn implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mybinder = (Iserivce) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

    @Override
    protected void onDestroy() {
        unbindService(myconn);
        super.onDestroy();
    }
}
