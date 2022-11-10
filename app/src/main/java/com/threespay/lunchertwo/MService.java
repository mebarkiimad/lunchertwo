package com.threespay.lunchertwo;

import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MService extends Service {
    private static final String TWOSCREENS_ACTION = "com.example.twoscreens.UI.MainActivity";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         Bundle bundle = intent.getExtras();

        if(intent.getAction().equals("twoscreens-action")) { //this action comes demo application using the intent filter for service defined in manifest
            try {
                String transaction = intent.getStringExtra("TRANSACTION");
                String amount = intent.getStringExtra("AMOUNT");
                String currency = intent.getStringExtra("CURRENCY");
                if (transaction.equals("")) {
                    Intent mIntent = new Intent("custom-event-name"); //send reciever data from twoscreesn application to cibplay ui maybe
                    mIntent.putExtra("message","Success received Message");
                    sendBroadcast(mIntent); //return this to ui
                }
                if (!transaction.equals("")) {
                    Intent mIntent = new Intent("custom-event-name"); //send reciever data from twoscreesn application to cibplay ui maybe
                    mIntent.putExtra("message","Success received Message");
                    sendBroadcast(mIntent); //return this to ui
                }
            } catch (Exception error) {

                Log.e("imad", error.getMessage());
            }
        }
        if(intent.getAction().equals("sucess-event-action")){
            Log.e("Action",intent.getStringExtra("sucess"));
        Intent mIntent = new Intent("custom-event-name");
        mIntent.putExtra("message","Success received Message");
        sendBroadcast(mIntent); //return this to ui

            // Try to invoke the intent.
            try {
            Intent sendIntent = new Intent();
            sendIntent.setAction(TWOSCREENS_ACTION);
            sendIntent.putExtra("SUCCESS",intent.getStringExtra("sucess"));
            sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } catch (ActivityNotFoundException e) {
                // Define what your app should do if no activity can handle the intent.
            }
        }else  if(intent.getAction().equals("fail-event-action")){
            Log.e("Action",intent.getStringExtra("fail"));
            Intent mIntent = new Intent("custom-event-name");
            mIntent.putExtra("message","Faill received Message");
            sendBroadcast(mIntent); //return this to ui activity
            try {
                Intent sendIntent = new Intent();
                sendIntent.setAction(TWOSCREENS_ACTION);
                sendIntent.putExtra("FAIL",intent.getStringExtra("fail"));
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            } catch (ActivityNotFoundException e) {
                // Define what your app should do if no activity can handle the intent.
            }
        }
        return START_STICKY;
    }
}
