package com.example.myappreoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.os.IResultReceiver;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/12.
 */
public class RemoteServcie extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Mybinder();
    }
    public void methodService(){
        Log.i("查讯结果", "methodService: ");
    }
     private class Mybinder extends IResultReceiver.Stub {
          public void  CallmethodService(){
              methodService();
         }


         @Override
         public void send(int i, Bundle bundle) throws RemoteException {

         }
     }
}
