package com.example.rohanjuneja_assignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PayByCardActivity extends AppCompatActivity   {
     EditText tbName;
    private EditText tbCard;
    private EditText tbCvc;
    private EditText tbCardExpiry;
    private EditText tbCricket;
    private EditText tbFavSinger;
    private EditText tbGraduate;
    private EditText tbTravel  ;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_by_card);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);






    }

    public void submitFn(View view){
        if(validate() == true){
            Toast toast = Toast.makeText(getApplicationContext(), "Payment Submitted", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if(validate() == false){
            Toast toast = Toast.makeText(getApplicationContext(), "All fields must be filled correctly", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public boolean validate(){
        boolean informationFilled = false;
        tbName = (EditText) findViewById(R.id.tbName);
        tbCard= (EditText)findViewById(R.id.tbCard);;
        tbCvc= (EditText)findViewById(R.id.tbCvc);;

        tbCardExpiry= (EditText)findViewById(R.id.tbCardExpiry);;
        tbCricket= (EditText)findViewById(R.id.tbCricket);;
        tbFavSinger= (EditText)findViewById(R.id.tbFavSinger);;
        tbGraduate= (EditText)findViewById(R.id.tbGraduate);;
        tbTravel = (EditText)findViewById(R.id.tbTravel); ;
        // check for empty entries
        if(tbName.getText().toString().length() == 0 && tbCard.getText().toString().length() != 16
                && tbCvc.getText().toString().length() != 3 && tbCardExpiry.getText().toString().length() != 4
                && tbCricket.getText().toString().length() == 0 && tbFavSinger.getText().toString().length() == 0 && tbGraduate.getText().toString().length() == 0 && tbTravel.getText().toString().length() == 0){
            informationFilled = false;
        }
        else
            {
            informationFilled = true;
        }

        return informationFilled;
    }
}