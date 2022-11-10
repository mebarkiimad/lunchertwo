package com.threespay.lunchertwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MessageListener {

    public  enum  Transaction {
        PAYMENT,
        REFUND,
        CANCEL
    }
private Intent intent;
    private TextView transactionTextView;
    private TextView priceTextView;
    private Button successBtn,failBtn;
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
//       intent = getIntent();
//       try {
//           String transaction = intent.getStringExtra("TRANSACTION");
//           String amount = intent.getStringExtra("AMOUNT");
//           String currency = intent.getStringExtra("CURRENCY");
//           if(transaction.equals("")){
//               transactionTextView = (TextView)findViewById(R.id.transaction_textview);
//               transactionTextView.setText(transaction);
//           }
//           if(!transaction.equals("")) {
//               priceTextView = (TextView)findViewById(R.id.price_textview);
//               priceTextView.setText(new StringBuilder().append(amount).append(" ").append(currency).toString());
//           }
//       }catch(Exception error){
//
//         Log.e("imad",error.getMessage());
//       }

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
            Intent intent = new Intent(this, MService.class);
            intent.setAction("sucess-event-action");
            intent.putExtra("sucess","1");
            this.startService(intent);
        }
        if(view.getId() == R.id.failBtn){
            Intent intent = new Intent(this, MService.class);
            intent.setAction("fail-event-action");
            intent.putExtra("fail","0");
            this.startService(intent);
        }
    }
    @Override
    public void onMessage(String message) {
        Log.e("Message","Braid dead");
    }
    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }
}