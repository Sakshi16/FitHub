package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class user_preference_checklist extends AppCompatActivity {
    Button mSaveBtn;
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

        mSaveBtn = findViewById(R.id.saveBtn);

        mSaveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Send preferences to backend for personalized feed
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}