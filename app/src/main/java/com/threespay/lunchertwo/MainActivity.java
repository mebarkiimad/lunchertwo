package com.threespay.lunchertwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.threespay.lunchertwo.model.BaseLinkyPosHeader;
import com.threespay.lunchertwo.model.BaseLinkyPosResponse;
import com.threespay.lunchertwo.model.BaseLinkyPosSignature;
import com.threespay.lunchertwo.service.MService;
import com.threespay.lunchertwo.util.Constants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MessageListener {

    public  enum  Transaction {
        PAYMENT,
        REFUND,
        CANCEL
    }
private Intent intent;
    private TextView transactionTextView;
    private TextView priceTextView;
    private Button successBtn,failBtn,startServiceBtn,stopServiceBtn;
    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broadcastReceiver = new MyBroadCastReceiver(this);
        successBtn = (Button)findViewById(R.id.successBtn);
        failBtn = (Button)findViewById(R.id.failBtn);
        successBtn.setOnClickListener(this);
        failBtn.setOnClickListener(this);
        startServiceBtn = (Button)findViewById(R.id.startServiceBtn);
        startServiceBtn.setOnClickListener(this);
        stopServiceBtn = (Button)findViewById(R.id.stopServiceBtn);
        stopServiceBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        IntentFilter filter = new IntentFilter("custom-event-name");
        registerReceiver(broadcastReceiver, filter);
        super.onResume();

    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.successBtn){
            sendMessage("1");
        }
        if(view.getId() == R.id.failBtn){
            sendMessage("0");
        }
        if(view.getId() == R.id.startServiceBtn){
            startService();
        }
        if(view.getId() == R.id.stopServiceBtn){
            endService();
        }
    }
    @Override
    public void onMessage(String message) {
        Log.e("Message","We got a message");
    }
    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }
    public void startService(){
        Intent myIntent = new Intent(Constants.ACTION_START);
        startService(myIntent);
    }
    public void endService(){
        Intent myIntent = new Intent(Constants.ACTION_STOP_SERVICE);
        startService(myIntent);
    }
    public void sendMessage(String value){
        Intent intent = new Intent(this, MService.class);
        intent.setAction(Constants.ACTION_DO_MESSAGE);
        intent.putExtra("STATUS",value);
        this.startService(intent);
    }
}