package com.example.rohanjuneja_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SemiDetatchedActivity extends AppCompatActivity {
    // References:
    // took some help from this website : https://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html
    // ListView AdapterClass code idea from  https://www.vogella.com/tutorials/AndroidListView/article.html
    ListView listingsList;
    ListAdapter listAdapter;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detatched_home);
        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        listingsList= (ListView)findViewById(R.id.listView);
        setTitle("Semi Detatched Homes - RJ");
        ArrayList<Listings> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Listings( R.drawable.img_semidetatchedhomes1, "435  Lover Parkway, Windsor, ON", "$5,476,999 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_semidetatchedhomes2, "342  Random blvd, Toronto, ON", "$77,550,999 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_semidetatchedhomes3, "32  Rohan Road, Caledon, ON", "$844,345 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_semidetatchedhomes4, "5454  Rohan Juneja St, Gulf, ON", "$654,500 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_semidetatchedhomes5, "234  Finally My name Road, Gulf, ON", "$557,657 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_semidetatchedhomes6 , "2343 Goto Ave, Toronto, ON", "$770,000 CAD" ));

        listAdapter = new ListAdapter(this,homesArrayList);
        listingsList.setAdapter(listAdapter);


        listingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SemiDetatchedActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                switch (position){
                    case 0:
                        Intent intent = new Intent(SemiDetatchedActivity.this,SemiDetatchedActivity.class);
                        startActivity(intent);
                }
                editor.commit();
            }
        });
    }

    public void enterSelectedHomeScreen(View view){
        Intent intent = new Intent(this, SelectedHomesActivity.class);
        startActivity(intent);
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