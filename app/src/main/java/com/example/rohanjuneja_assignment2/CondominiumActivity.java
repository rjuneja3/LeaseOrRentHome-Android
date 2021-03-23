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

public class CondominiumActivity extends AppCompatActivity {
    // References:
    // took some help from this website : https://www.mysamplecode.com/2012/07/android-listview-checkbox-example.html
    // ListView AdapterClass code idea from  https://www.vogella.com/tutorials/AndroidListView/article.html
    ListView listingsList;
    ListAdapter listAdapter;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condominium);
        sharedPreferences = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        listingsList= (ListView)findViewById(R.id.listView);
        setTitle("Condominiums - RJ");
        ArrayList<Listings> homesArrayList= new ArrayList<>();
        homesArrayList.add(new Listings( R.drawable.img_condominiums1, "3877  th Street, Calgary AB", "$1,002,999 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_condominiums2, "1246  Wyecroft Road, Toronto, ON", "$2,120,999 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_condominiums3, "780  Lynden Road, Caledon, ON", "$599,900 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_condominiums4, "339  Port Washington Road, Gulf, ON", "$980,000 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_condominiums5, "371  Port Washington Road, Gulf, ON", "$351,000 CAD" ));
        homesArrayList.add(new Listings( R.drawable.img_condominiums6 , "3027  Pape Ave", "$440,000 CAD" ));

        listAdapter = new ListAdapter(this,homesArrayList);
        listingsList.setAdapter(listAdapter);


        listingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CondominiumActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                switch (position){
                    case 0:
                        Intent intent = new Intent(CondominiumActivity.this,DetatchedHomeActivity.class);
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