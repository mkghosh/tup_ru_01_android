package com.example.mithunkumerghose.broadcastreceiverdemo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;



/**
 * @author Mithun Kumer Ghose.
 */

public class MyService extends Service {

    private long startTime;
    private Context mContext;

    public MyService() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Toast.makeText(mContext, "Service is Creating.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//            }
//        });
        Toast.makeText(mContext, "Service is Starting", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(mContext, "Service is going to be Destroyed", Toast.LENGTH_SHORT).show();
    }
}
