package com.example.myappban;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private MainActivity.myconn conn;

    private BanZhengService.MyBinder myBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,BanZhengService.class);
        conn = new myconn();
        //连接服务
        bindService(intent, conn,BIND_AUTO_CREATE);
    }
//    public void click(View v){
//        Intent intent = new Intent();
//        intent.setClass(this,BanZhengService.class);
//        startService(intent);
//    }
  private class myconn implements ServiceConnection {
      @Override
      public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
          myBinder = (BanZhengService.MyBinder) iBinder;
      }
      @Override
      public void onServiceDisconnected(ComponentName componentName) {
      }
  }
    public void click(View v){
          myBinder.callbanzheng(100);
    }
//销毁绑定服务
    @Override
    protected void onDestroy() {
       unbindService(conn);
        super.onDestroy();
    }
}
