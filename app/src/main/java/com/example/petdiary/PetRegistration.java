package com.example.petdiary;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import java.io.ByteArrayOutputStream;

public class PetRegistration extends AppCompatActivity {

    TextView datapicker_textview;
    Spinner spinner;
    Intent intent;
    byte[] arr;
    Bitmap image;
    ImageView PhotoImage;
    EditText pet_name;
    RadioButton man;
    RadioButton woman;
    String gender;
    EditText blood_type;
    //String dateMessage;
    EditText weight;
    String spinner_select;
    SharedPreferences sharedPreferences; // sharedPreferences 변수
    String photo_data; // sharedPreferences 사진 정보
    String petname_data; // sharedPreferences 이름 정보
    String kind_data; // sharedPreferences 품종 정보
    int kind_item_data; // sharedPreferences 품종 순서 정보
    String gender_data; // sharedPreferences 성별 정보
    String blood_data; // sharedPreferences 혈액형 정보
    String birth_data; // sharedPreferences 생일 정보
    String weight_data; // sharedPreferences 체중 정보
    byte[] encodeByte;
    int spinner_item;
    TextView datapicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_registration);

        datapicker_textview = findViewById(R.id.datapicker_textview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        spinner = findViewById(R.id.kind_spinner);
        pet_name = findViewById(R.id.pet_name_edittext);
        man = findViewById(R.id.radio_man);
        woman = findViewById(R.id.radio_woman);
        gender = null;
        blood_type = findViewById(R.id.blood_edittext);
        weight = findViewById(R.id.weight_edittext);
        PhotoImage = findViewById(R.id.pet_photo);
        datapicker = findViewById(R.id.datapicker_textview);

        sharedPreferences = getSharedPreferences("sharedPreferences", Activity.MODE_PRIVATE);
        photo_data = sharedPreferences.getString("inputPhoto", null);
        petname_data = sharedPreferences.getString("inputName", null);
        kind_data = sharedPreferences.getString("inputKind", null);
        kind_item_data = sharedPreferences.getInt("inputKind_item", 0);
        gender_data = sharedPreferences.getString("inputGender", null);
        blood_data = sharedPreferences.getString("inputBlood", null);
        birth_data = sharedPreferences.getString("inputBirth", null);
        weight_data = sharedPreferences.getString("inputWeight", null);

        try {
            encodeByte = Base64.decode(photo_data, Base64.DEFAULT);
            image = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            PhotoImage.setImageBitmap(image);
        } catch (NullPointerException e) {

        }

        pet_name.setText(petname_data);
        if (gender_data != null) {
            if (gender_data.equals("수컷") == true) {
                man.setChecked(true);
            } else if (gender_data.equals("암컷") == true) {
                woman.setChecked(true);
            }
        }
        blood_type.setText(blood_data);
        datapicker.setText(birth_data);
        weight.setText(weight_data);

        intent = getIntent();
        arr = getIntent().getByteArrayExtra("image");


        try {
            image = BitmapFactory.decodeByteArray(arr, 0, arr.length);
        } catch (NullPointerException e) {
            PhotoImage.setImageResource(R.drawable.add_photo);
        }

        if(image != null) {
            PhotoImage.setImageBitmap(image);
        }


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cat_kind, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(kind_item_data);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                /*Toast.makeText(adapterView.getContext(), "선택된 품종은 " + adapterView.getItemAtPosition(pos).toString()
                        , Toast.LENGTH_SHORT).show();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle("반려동물 정보");

        ImageView photo_select = (ImageView) findViewById(R.id.pet_photo);
        photo_select.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PetRegistration.this, PetPhoto.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_man:
                if(checked)
                    Toast.makeText(getApplicationContext(), ((RadioButton) view).getText() ,Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_woman:
                if(checked)
                    Toast.makeText(getApplicationContext(), ((RadioButton) view).getText() ,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home: {

                //액티비티 이동
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
                }
            }
            return super.onOptionsItemSelected(item);
        }

        public void showDatePicker (View v) { // 캘린더 메소드
            DialogFragment birthFragment = new BirthPickerFragment();
            birthFragment.show(getSupportFragmentManager(), "datePicker");
        }

       public void processDatePickerResult ( int year, int month, int day){ // 캘린더 메소드
            String month_string = Integer.toString(month + 1);
            String day_string = Integer.toString(day);
            String year_string = Integer.toString(year);
            //dateMessage = (year_string + "-" + month_string + "-" + day_string);

            datapicker_textview.setText(year_string + "-" + month_string + "-" + day_string);
            //Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
        }

        public void registrationClick(View view) {
            spinner_select = spinner.getSelectedItem().toString();
            spinner_item = spinner.getSelectedItemPosition();

            BitmapDrawable drawable1 = (BitmapDrawable) PhotoImage.getDrawable();

            Bitmap bitmap = drawable1.getBitmap();
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos1);
            byte[] bytes1 = baos1.toByteArray();
            String temp = Base64.encodeToString(bytes1, Base64.DEFAULT);

            SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", Activity.MODE_PRIVATE);

            SharedPreferences.Editor autoLogin = sharedPreferences.edit();

            autoLogin.putString("inputPhoto", temp);
            autoLogin.putString("inputName", pet_name.getText().toString());
            if(man.isChecked()) {
                autoLogin.putString("inputGender", man.getText().toString());
            } else if(woman.isChecked()) {
                autoLogin.putString("inputGender", woman.getText().toString());
            }
            autoLogin.putString("inputKind", spinner_select);
            autoLogin.putInt("inputKind_item", spinner_item);
            autoLogin.putString("inputBlood", blood_type.getText().toString());
            autoLogin.putString("inputBirth", datapicker_textview.getText().toString());
            autoLogin.putString("inputWeight", weight.getText().toString());

            autoLogin.commit();
            Toast.makeText(getApplicationContext(), pet_name.getText().toString() +"집사님 환영합니다.", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
    }
    }
