package com.example.petdiary;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PetDetail extends AppCompatActivity {

    HomeFragment homeFragment;
    DiaryFragment diaryFragment;
    KaKaoLocation locationFragment;
    SharedPreferences sharedPreferences; // sharedPreferences 변수
    String photo_data; // sharedPreferences 사진 정보
    String petname_data; // sharedPreferences 이름 정보
    String kind_data; // sharedPreferences 품종 정보
    String gender_data; // sharedPreferences 성별 정보
    String blood_data; // sharedPreferences 혈액형 정보
    String birth_data; // sharedPreferences 생일 정보
    String weight_data; // sharedPreferences 체중 정보
    ImageView select_photo;
    byte[] encodeByte;
    Bitmap image_data;
    TextView pet_name;
    TextView pet_gender;
    TextView pet_kind;
    TextView pet_blood;
    TextView pet_birth;
    TextView pet_weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_detail);

        homeFragment = new HomeFragment();
        diaryFragment = new DiaryFragment();
        locationFragment = new KaKaoLocation();

        select_photo = findViewById(R.id.pet_photo);
        pet_name = findViewById(R.id.pet_name);
        pet_gender = findViewById(R.id.gender_textview2);
        pet_kind = findViewById(R.id.kind_textview2);
        pet_blood = findViewById(R.id.blood_textview2);
        pet_birth = findViewById(R.id.birth_textview);
        pet_weight = findViewById(R.id.weight_textview2);

        sharedPreferences = getSharedPreferences("sharedPreferences", Activity.MODE_PRIVATE);
        photo_data = sharedPreferences.getString("inputPhoto", null);
        petname_data = sharedPreferences.getString("inputName", null);
        kind_data = sharedPreferences.getString("inputKind", null);
        gender_data = sharedPreferences.getString("inputGender", null);
        blood_data = sharedPreferences.getString("inputBlood", null);
        birth_data = sharedPreferences.getString("inputBirth", null);
        weight_data = sharedPreferences.getString("inputWeight", null);

        encodeByte = Base64.decode(photo_data, Base64.DEFAULT);
        image_data = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        select_photo.setImageBitmap(image_data);

        pet_name.setText(petname_data);
        pet_gender.setText(gender_data);
        pet_kind.setText(kind_data);
        pet_blood.setText(blood_data);
        pet_birth.setText(birth_data);
        pet_weight.setText(weight_data);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle("반려동물 정보");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case android.R.id.home:{
                    //액티비티 이동
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    return true;
                }
            }
            return super.onOptionsItemSelected(item);
    }

}
