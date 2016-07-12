 package com.example.myappxiaomi;

 import android.content.ComponentName;
 import android.content.Intent;
 import android.content.ServiceConnection;
 import android.os.Bundle;
 import android.os.IBinder;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;

 public class MainActivity extends AppCompatActivity {


     private Myconn myconn;
     private Iservice myBinder;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,BanZhengService.class);
         myconn = new Myconn();
        bindService(intent, myconn,BIND_AUTO_CREATE );
    }
    private class Myconn implements ServiceConnection{
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (Iservice) iBinder;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
    public void click(View v){
              myBinder.callbanzheng(20);
        myBinder.callplayMAJiaing();
        myBinder.callseleep();
    }
     @Override
     protected void onDestroy() {
         unbindService(myconn);
         super.onDestroy();
     }
 }
