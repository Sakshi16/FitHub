package com.example.fithub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fithub.ui.profile.ProfileFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user_preference_checklist extends AppCompatActivity {
    Button mSaveBtn;
    ListView listviewData;
    ArrayAdapter<String> adapter;
    String[] arrayCatagories = {"Outdoor sports", "Indoor sports", "Cardio", "Yoga", "Hiking", "Weight training",
            "Climbing", "Balance training", "Flexibility" };
    String[] interests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_preference_checklist);

        listviewData = findViewById(R.id.listview_data);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arrayCatagories);
        listviewData.setAdapter(adapter);

        //Add selected items to string array which will be sent as interests
        listviewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //interests += listviewData[position].toString();
            }
        });

        //Add choices to user interests
        FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Users")
                .child(fUser.getUid()).child("interests");

        mSaveBtn = findViewById(R.id.saveBtn);

        mSaveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Send preferences to backend for personalized feed
                reference.setValue("interest1").addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(user_preference_checklist.this, "Interests added to profile", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                });
            }
        });

    }
}