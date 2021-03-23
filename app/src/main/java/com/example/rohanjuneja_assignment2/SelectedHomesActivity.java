package com.example.rohanjuneja_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelectedHomesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_homes);

        int index = 0;
        RadioGroup radioGroup = findViewById(R.id.radioBtnGroup);
        for (final Listings home : SaveItem.selectedHomes)
        {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setId(index++);
            radioButton.setText(home.getAddress()+" "+home.getPrice());


            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(getApplicationContext(), CheckoutActivity.class );
                    Bundle bundle=new Bundle();
                    bundle.putString("price",home.getPrice());

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            radioGroup.addView(radioButton);
        }
    }


}