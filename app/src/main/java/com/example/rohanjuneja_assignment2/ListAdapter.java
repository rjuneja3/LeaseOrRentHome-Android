package com.example.rohanjuneja_assignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;



// ListView AdapterClass code idea from  https://www.vogella.com/tutorials/AndroidListView/article.html
public class ListAdapter extends ArrayAdapter <Listings>{

    public static List<Listings> selectedHomes = new ArrayList<>();

    private Context context;
    private List<Listings> homeList = new ArrayList<>();
    public ListAdapter(Context context, ArrayList<Listings> list){
        super(context, 0 , list);
        this.context = context;
        homeList = list;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if (listItem==null){
            listItem= LayoutInflater.from(context).inflate( R.layout.listings_style,parent,false );
        }


        Listings home=homeList.get( position );
        ImageView imageView = (ImageView)listItem.findViewById( R.id.image_View_list );
        imageView.setImageResource( home.getImage() );

        TextView tvAddress =(TextView)listItem.findViewById( R.id.textView_opt1 );
        tvAddress.setText( home.getAddress() );
        TextView tvPrice = (TextView)listItem.findViewById( R.id.textView_opt2 );
        tvPrice.setText( home.getPrice());


        final CheckBox checkBox = listItem.findViewById(R.id.checkboxlist);
        checkBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                if(checkBox.isChecked())
                {
                    SaveItem.selectedHomes.add(homeList.get( position ));
                }
                else
                {
                    SaveItem.selectedHomes.remove(homeList.get( position ));
                }

            }
        });

        return listItem;

    }


}
