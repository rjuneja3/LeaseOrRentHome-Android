package com.example.rohanjuneja_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        setTitle("Welcome, Select an option");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hometype, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Class activity;
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_apartment:
                activity = ApartmentsActivity.class;
                intent = new Intent(this, activity);
                startActivity(intent);
                return true;
            case R.id.menu_condominium:
                activity = CondominiumActivity.class;
                intent = new Intent(this, activity);
                startActivity(intent);
                return true;
            case R.id.menu_detatchedHome:
                activity = DetatchedHomeActivity.class;
                intent = new Intent(this, activity);
                startActivity(intent);
                return true;
            case R.id.menu_semiDetatched:
                activity = SemiDetatchedActivity.class;
                intent = new Intent(this, activity);
                startActivity(intent);
                return true;
            case R.id.menu_townHouse:
                activity = TownHouseActivity.class;
                intent = new Intent(this, activity);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}