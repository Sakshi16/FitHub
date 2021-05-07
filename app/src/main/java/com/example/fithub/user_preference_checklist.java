package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class user_preference_checklist extends AppCompatActivity {

    ListView listviewData;
    ArrayAdapter<String> adapter;
    String[] arrayCatagories = {"Outdoor sports", "Indoor sports", "Cardio", "Yoga", "Hiking", "Weight training",
            "Climbing", "Balance training", "Flexibility" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preference_checklist);

        listviewData = findViewById(R.id.listview_data);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arrayCatagories);
        listviewData.setAdapter(adapter);


    }
}