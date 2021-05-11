package com.example.fithub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {

    EditText mFullname, mEmail, mUsername, mPassword, mConfirmPassword;
    Button mRegisterBtn;
    TextView mLoginBtn;

    private FirebaseAuth fAuth;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullname           = findViewById(R.id.name);
        mEmail              = findViewById(R.id.email);
        mUsername           = findViewById(R.id.username);
        mPassword           = findViewById(R.id.password);
        mConfirmPassword    = findViewById(R.id.confirmPassword);
        mRegisterBtn        = findViewById(R.id.registerBtn);
        mLoginBtn           = findViewById(R.id.log);

        //Initialize Firebase Auth
        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = mFullname.getText().toString().trim();
                String username = mUsername.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String confirmPassword = mConfirmPassword.getText().toString().trim();

                //Error handling copied in Login
                if(TextUtils.isEmpty(fullname)) {
                    mFullname.setError("Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(username)) {
                    mUsername.setError("Username is Required.");
                    return;
                }

                if(TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length() < 6) {
                    mPassword.setError("Password must be at least 6 characters");
                    return;
                }

                if(!confirmPassword.matches(password)) {
                    mConfirmPassword.setError("Passwords do not match.");
                    return;
                }

                //register the user in firebase
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
                            User user = new User(username, fullname, email, null, "Bio");
                                FirebaseDatabase.getInstance().getReference("Users")
                                    .child(fUser.getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(),user_preference_checklist.class));                                        }
                                    }
                                });

                                //Email verification
//                            if (fUser.isEmailVerified()) {
//                                Toast.makeText(Register.this, "Logged in successfully.", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                            }else{
//                                fUser.sendEmailVerification();
//                                Toast.makeText(Register.this, "Check your email to verify your account!", Toast.LENGTH_LONG).show();
//                            }

                        }
                        else{
                            Toast.makeText(Register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

    }

}