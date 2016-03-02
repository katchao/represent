package com.example.katherine.represent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by katherine on 29/02/2016.
 */
public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Intent i = getIntent();
        final String zipCode = i.getExtras().getString("location");
        final ArrayList<Person> listOfPeople = i.getParcelableArrayListExtra("listOfPeople");

        //populate zipcode
        TextView zipCodeText = (TextView) findViewById(R.id.zipcode_list);
        zipCodeText.setText("Current Location: " + zipCode);

        //populate list
        ListAdapter adapter = new ListAdapter(this, listOfPeople);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}
