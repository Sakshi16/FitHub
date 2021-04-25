package com.example.fithub.ui.profile;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fithub.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileViewModel extends ViewModel {
    FirebaseAuth fAuth = FirebaseAuth.getInstance();

    private MutableLiveData<String> mText;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("User:" + fAuth.getCurrentUser().getEmail());
    }

    public LiveData<String> getText() {
        return mText;
    }
}