package com.example.myapploaclservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private Mybinder mybinder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setAction("com.zdwl.remoteserto");
        mybinder1 = new Mybinder();
//        连接服务为了获取的对象
        bindService(intent,mybinder1,BIND_AUTO_CREATE);
    }
    public void click(View v){

    }
    private class  Mybinder implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IResultReceiver.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

    @Override
    protected void onDestroy() {
        unbindService(mybinder1);
        super.onDestroy();
    }
}
