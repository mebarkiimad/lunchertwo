package com.threespay.lunchertwo.service;

import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.threespay.lunchertwo.model.BaseLinkyPosHeader;
import com.threespay.lunchertwo.model.BaseLinkyPosPayload;
import com.threespay.lunchertwo.model.BaseLinkyPosRequest;
import com.threespay.lunchertwo.model.BaseLinkyPosResponse;
import com.threespay.lunchertwo.model.BaseLinkyPosResponsePayload;
import com.threespay.lunchertwo.model.BaseLinkyPosSignature;
import com.threespay.lunchertwo.util.Constants;

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
        String action = intent.getAction();
        Intent mIntent = new Intent("custom-event-name");

        switch (action){
            case Constants.ACTION_START:

                break;
            case  Constants.ACTION_DO_MESSAGE:

                BaseLinkyPosHeader baseLinkyPosHeader = new BaseLinkyPosHeader();
                BaseLinkyPosResponsePayload baseLinkyPosPayload = new BaseLinkyPosResponsePayload();
                BaseLinkyPosSignature baseLinkyPosSignature = new BaseLinkyPosSignature();
                BaseLinkyPosResponse baseLinkyPosResponse = new BaseLinkyPosResponse();
                baseLinkyPosResponse.setHeader(baseLinkyPosHeader);
                baseLinkyPosResponse.setSignature(baseLinkyPosSignature);
                String value = intent.getStringExtra("STATUS");
                baseLinkyPosResponse.setPayload(baseLinkyPosPayload);
            Intent sendIntent = new Intent();
            sendIntent.setAction(TWOSCREENS_ACTION);
            sendIntent.putExtra("STATUS",baseLinkyPosResponse.toJson().toString());
            sendIntent.setType("text/plain");
                startActivity(sendIntent);

                mIntent.putExtra("message","Success received Message");
                sendBroadcast(mIntent); //return this to ui
                break;
            case  Constants.ACTION_STOP_SERVICE:
                stopService();
                break;
            case "twoscreens-action":
                BaseLinkyPosRequest baseLinkyPosRequest = new BaseLinkyPosRequest();
                            try {
                String transaction = intent.getStringExtra("TRANSACTION");
                baseLinkyPosRequest = baseLinkyPosRequest.fromJson(transaction);
                String amount = intent.getStringExtra("AMOUNT");
                String currency = intent.getStringExtra("CURRENCY");
                mIntent.putExtra("message",baseLinkyPosRequest.toJson().toString());
                sendBroadcast(mIntent); //return this to ui
            } catch (Exception error) {

                Log.e("imad", error.getMessage());
            }
                break;
        }
        return START_STICKY;
//        if(intent.getAction().equals("twoscreens-action")) { //this action comes demo application using the intent filter for service defined in manifest
//            try {
//                String transaction = intent.getStringExtra("TRANSACTION");
//                String amount = intent.getStringExtra("AMOUNT");
//                String currency = intent.getStringExtra("CURRENCY");
//                if (transaction.equals("")) {
//                    Intent mIntent = new Intent("custom-event-name"); //send reciever data from twoscreesn application to cibplay ui maybe
//                    mIntent.putExtra("message","Success received Message");
//                    sendBroadcast(mIntent); //return this to ui
//                }
//                if (!transaction.equals("")) {
//                    Intent mIntent = new Intent("custom-event-name"); //send reciever data from twoscreesn application to cibplay ui maybe
//                    mIntent.putExtra("message","Success received Message");
//                    sendBroadcast(mIntent); //return this to ui
//                }
//            } catch (Exception error) {
//
//                Log.e("imad", error.getMessage());
//            }
//        }
//        if(intent.getAction().equals("sucess-event-action")){
//            Log.e("Action",intent.getStringExtra("STATUS"));
//        Intent mIntent = new Intent("custom-event-name");
//        mIntent.putExtra("message","Success received Message");
//        sendBroadcast(mIntent); //return this to ui
//
//            // Try to invoke the intent.
//            try {
//            Intent sendIntent = new Intent();
//            sendIntent.setAction(TWOSCREENS_ACTION);
//            sendIntent.putExtra("STATUS",intent.getStringExtra("STATUS"));
//            sendIntent.setType("text/plain");
//                startActivity(sendIntent);
//            } catch (ActivityNotFoundException e) {
//                // Define what your app should do if no activity can handle the intent.
//            }
//        }else
//            if(intent.getAction().equals("fail-event-action")){
//            Log.e("Action",intent.getStringExtra("STATUS"));
//            Intent mIntent = new Intent("custom-event-name");
//            mIntent.putExtra("message","Faill received Message");
//            sendBroadcast(mIntent); //return this to ui activity
//            try {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(TWOSCREENS_ACTION);
//                sendIntent.putExtra("STATUS",intent.getStringExtra("STATUS"));
//                sendIntent.setType("text/plain");
//                startActivity(sendIntent);
//            } catch (ActivityNotFoundException e) {
//                // Define what your app should do if no activity can handle the intent.
//            }
//        }
//        return START_STICKY;
    }
    public void stopService(){
        //...destroy/release objects
       this.stopSelf();
    }
}