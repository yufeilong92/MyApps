package com.example.myappban;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/12.
 */
public class BanZhengService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    private void banzheng(int money){
        if(money>10){
             Toast.makeText(getApplicationContext() ,"给我欧版额", Toast.LENGTH_SHORT).show();
        }else {
             Toast.makeText( getApplicationContext(),"补办叫10元", Toast.LENGTH_SHORT).show();
        }
    }
    //[☆]d定义一个中间人的对象（IBinder）
    public class MyBinder extends Binder{
        public void callbanzheng(int money){
            //[☆]调用办证方法
            banzheng(money);
        }
    }
}
