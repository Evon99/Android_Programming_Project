package com.example.petdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    DiaryFragment diaryFragment;
    KaKaoLocation KaKaoLocation;
    SharedPreferences sharedPreferences;
    String photo_data;
    String petname_data;
    ImageView select_photo;
    Button update_button;
    Button delete_button;
    byte[] encodeByte;
    Bitmap image_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        diaryFragment = new DiaryFragment();
        KaKaoLocation = new KaKaoLocation();
        /*select_photo = findViewById(R.id.select_photo);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        sharedPreferences = getSharedPreferences("sharedPreferences", Activity.MODE_PRIVATE);
        photo_data = sharedPreferences.getString("inputPhoto", null);
        petname_data = sharedPreferences.getString("inputName", null);

        if(petname_data == null) {
            Intent intent = new Intent(getApplicationContext(), FirstStart.class);
            startActivity(intent);
            finish();
        }

        try {
            encodeByte = Base64.decode(photo_data, Base64.DEFAULT);
            image_data = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            select_photo.setImageBitmap(image_data);
        } catch (NullPointerException e) {

        }

        select_photo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PetDetail.class);
                startActivity(intent);
                finish();
            }
        });

        update_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PetRegistration.class);
                startActivity(intent);
                finish();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor autoLogin = sharedPreferences.edit();
                autoLogin.clear();
                autoLogin.commit();
                Intent intent = new Intent(MainActivity.this, FirstStart.class);
                startActivity(intent);
                finish();
            }
        }); */

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, homeFragment).commit();
                        return true;
                    case R.id.diary:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, diaryFragment).commit();
                        return true;
                    case R.id.location:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, KaKaoLocation).commit();
                        return true;
                }
                return false;
            }

        });

    }
}