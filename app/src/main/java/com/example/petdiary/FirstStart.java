package com.example.petdiary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class FirstStart extends AppCompatActivity {

    HomeFragment homeFragment;
    DiaryFragment diaryFragment;
    KaKaoLocation locationFragment;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_start);

        homeFragment = new HomeFragment();
        diaryFragment = new DiaryFragment();
        locationFragment = new KaKaoLocation();

        Button registration_b = (Button)findViewById(R.id.registration_button);
        registration_b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PetRegistration.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
    