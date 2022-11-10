package com.threespay.lunchertwo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyBroadCastReceiver extends BroadcastReceiver {
    private MessageListener messageListener;
    public MyBroadCastReceiver( MessageListener messageListener){
        this.messageListener = messageListener;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String message = bundle.getString("message");
        messageListener.onMessage(message);
    }
}
