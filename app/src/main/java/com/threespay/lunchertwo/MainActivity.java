package com.threespay.lunchertwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {
    public  enum  Transaction {
        PAYMENT,
        REFUND,
        CANCEL
    }
private Intent intent;
    private TextView transactionTextView;
    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       intent = getIntent();
       try {
           String transaction = intent.getStringExtra("TRANSACTION");
           String amount = intent.getStringExtra("AMOUNT");
           String currency = intent.getStringExtra("CURRENCY");
           if(transaction.equals("")){
               transactionTextView = (TextView)findViewById(R.id.transaction_textview);
               transactionTextView.setText(transaction);
           }
           if(!transaction.equals("")) {
               priceTextView = (TextView)findViewById(R.id.price_textview);
               priceTextView.setText(new StringBuilder().append(amount).append(" ").append(currency).toString());
           }
       }catch(Exception error){

         Log.e("imad",error.getMessage());
       }

    }
}