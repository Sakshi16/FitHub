package com.example.fithub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class user_preference_checklist extends AppCompatActivity {
    Button mBackBtn;
    Button mSaveBtn;
    ListView listviewData;
    ArrayAdapter<String> adapter;
    String[] arrayCatagories = {"Outdoor sports", "Indoor sports", "Cardio", "Yoga", "Hiking", "Weight training",
            "Climbing", "Balance training", "Flexibility" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_preference_checklist);

        listviewData = findViewById(R.id.listview_data);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arrayCatagories);
        listviewData.setAdapter(adapter);

        mBackBtn = findViewById(R.id.backBtn);
        mSaveBtn = findViewById(R.id.saveBtn);

        mBackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

        mSaveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Send preferences to backend for personalized feed
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}