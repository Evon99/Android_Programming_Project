package com.example.petdiary;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.ByteArrayOutputStream;
import java.net.URL;

public class PetPhoto extends AppCompatActivity {

    Button finish_b;
    static byte[] byteArray;
    Bitmap sendBitmap = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_photo);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기
        getSupportActionBar().setTitle("반려동물 사진 선택");

        init();
        ClickListener();
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home: {

                //액티비티 이동
                Intent intent = new Intent(getApplicationContext(), PetRegistration.class);
                startActivity(intent);
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickCat1(View view) {
        sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat1);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat2(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat2);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat3(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat3);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat4(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat4);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat5(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat5);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat6(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat6);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat7(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat7);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat8(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat8);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat9(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat9);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat10(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat10);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat11(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat11);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat12(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat12);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat13(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat13);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat14(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat14);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat15(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat15);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat16(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat16);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat17(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat17);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat18(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat18);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat19(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat19);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat20(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat20);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat21(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat21);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat22(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat22);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat23(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat23);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat24(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat24);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat25(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat25);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat26(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat26);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat27(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat27);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    public void onClickCat28(View view) {
        Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat28);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byteArray = stream.toByteArray();
        Toast.makeText(getApplicationContext(), "이미지 선택 완료", Toast.LENGTH_SHORT).show();
    }

    private void init() {
        finish_b = findViewById(R.id.photo_finish);
    }

    private void ClickListener() {
        finish_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PetPhoto.this, PetRegistration.class);
                intent.putExtra("image", byteArray);
                startActivity(intent);
                finish();
            }
        });
    }
}
