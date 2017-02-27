package com.example.mithunkumerghose.broadcastreceiverdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * @author Mithun Kumer Ghose.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "The received Intent is : " + intent.getAction(), Toast.LENGTH_SHORT).show();
    }

}
