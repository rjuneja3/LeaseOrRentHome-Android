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

public class TownHouseActivity extends AppCompatActivity {

    // References:
    // took some help from this website : https://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html
    // ListView AdapterClass code idea from  https://www.vogella.com/tutorials/AndroidListView/article.html
    ListView listingsList;
    ListAdapter listAdapter;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_house);
        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        listingsList= (ListView)findViewById(R.id.listView);
        setTitle("Town Houses - RJ");
        ArrayList<Listings> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Listings( R.drawable.img_townhouses1, "32  Another Parkway, Windsor, ON", "$8,076,999 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_townhouses2, "88  One More RD, Toronto, ON", "$77,980,999 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_townhouses3, "367  Assignhe Blvd, Caledon, ON", "$64,055 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_townhouses4, "43545  Rohan Juneja St, Gulf, ON", "$686,000 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_townhouses5, "3  Yoyo street, Gulf, ON", "$667,857 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_townhouses6 , "5 Geazy Ave, Toronto, ON", "$950,000 CAD" ));

        listAdapter = new ListAdapter(this,homesArrayList);
        listingsList.setAdapter(listAdapter);


        listingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TownHouseActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                switch (position){
                    case 0:
                        Intent intent = new Intent(TownHouseActivity.this,TownHouseActivity.class);
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