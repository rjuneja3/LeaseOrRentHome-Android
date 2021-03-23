package com.example.rohanjuneja_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {
    private TextView itemsListed,item,paymentInfo;
    String price;
    //    private double paymentTotal;
    private String paymentOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        setTitle("Checkout - Payment options");

        Intent intent=new Intent();
        Bundle bundle= getIntent().getExtras();
        price=bundle.getString("price");


        item=findViewById(R.id.itemsListed);
        item.setText("Your total payment: "+price.toString());




        ((RadioGroup) findViewById(R.id.paymentOptions)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idChecked) {
                Bundle bundle;

                switch (idChecked) {
                    case R.id.rbtnCash:
                        paymentOption = "Cash";
                        break;
                    case R.id.rbtnCreditCard:
                        paymentOption = "CreditCard";
                        break;
                    case R.id.rbtnDebitCard:
                        paymentOption = "DebitCard";
                        break;
                }
            }
        });

        findViewById(R.id.btnCheckout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle;

                switch (((RadioGroup) findViewById(R.id.paymentOptions)).getCheckedRadioButtonId()) {
                    case R.id.rbtnCash:
                        Intent intent= new Intent(CheckoutActivity.this, CashPaymentActivity.class );
                        bundle = new Bundle();
                        bundle.putString("price",price);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    case R.id.rbtnCreditCard:
                    case R.id.rbtnDebitCard:
                        intent= new Intent(CheckoutActivity.this, PayByCardActivity.class );
                        bundle = new Bundle();
                        bundle.putString("price",price);
                        intent.putExtras(bundle);
                        startActivity(intent);

                        break;
                }
            }
        });







    }
}