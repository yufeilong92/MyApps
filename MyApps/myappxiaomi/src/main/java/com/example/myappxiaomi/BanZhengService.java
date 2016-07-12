package com.example.myappxiaomi;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/7/12.
 */
public class BanZhengService extends Service {
    private final static String TAG = "查询结果";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    private void banzheng(int money) {
        if (money > 10) {
            Toast.makeText(getApplicationContext(), "给我欧版额", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "补办叫10元", Toast.LENGTH_SHORT).show();
        }
    }

    //[☆]d定义一个中间人的对象（IBinder）
    private class MyBinder extends Binder implements Iservice {
        public void callbanzheng(int money) {
            //[☆]调用办证方法
            banzheng(money);
        }

        public void callplayMAJiaing() {
            playMAJiaing();
        }

        public void callseleep() {
            seleep();
        }
    }

    public void playMAJiaing() {
        Log.i(TAG, "陪领导打麻将: ");
    }

    private void seleep() {
        Log.i(TAG, "seleep: 和领导睡觉");
    }

}
