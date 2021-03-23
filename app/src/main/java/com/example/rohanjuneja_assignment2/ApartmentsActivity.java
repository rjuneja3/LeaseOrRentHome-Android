package com.example.rohanjuneja_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.AdapterView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ApartmentsActivity extends AppCompatActivity {
    // References:
    // took some help from this website : https://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html
    // ListView AdapterClass code idea from  https://www.vogella.com/tutorials/AndroidListView/article.html
    ListView listingsList;
    ListAdapter listAdapter;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartments);

        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);

        listingsList= (ListView)findViewById(R.id.listView);
        setTitle("Apartments - RJ");
        ArrayList<Listings> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Listings( R.drawable.img_apartment1, "16 Kentish Crescent, Toronto, ON", "$2,032,999 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_apartment2, "430 Fiction Street, Toronto, ON", "$3,100,000 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_apartment3, "16 Belle Drive, Belleville, ON", "$999,900 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_apartment4, "423 Gulfyyyy St, Gulf, ON", "$900,000 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_apartment5, "322 87th Street, Edmonton, AB", "$452,000 CAD" ));

        listAdapter = new ListAdapter(this,homesArrayList);
        listingsList.setAdapter(listAdapter);


        listingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Toast.makeText(ApartmentsActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        Intent intent = new Intent(ApartmentsActivity.this,ApartmentsActivity.class);
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