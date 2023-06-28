package com.example.petdiary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class HomeFragment extends Fragment {

    SharedPreferences sharedPreferences;
    String photo_data;
    String petname_data;
    ImageView select_photo;
    Button update_button;
    Button delete_button;
    byte[] encodeByte;
    Bitmap image_data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View homeview = inflater.inflate(R.layout.fragment_home, container, false);
        select_photo = homeview.findViewById(R.id.select_photo);
        update_button = homeview.findViewById(R.id.update_button);
        delete_button = homeview.findViewById(R.id.delete_button);

        sharedPreferences = getActivity().getSharedPreferences("sharedPreferences", Activity.MODE_PRIVATE);
        photo_data = sharedPreferences.getString("inputPhoto", null);
        petname_data = sharedPreferences.getString("inputName", null);

        if(petname_data == null) {
            Intent intent = new Intent(getActivity(), FirstStart.class);
            startActivity(intent);
            getActivity().finish();
        }

        try {
            encodeByte = Base64.decode(photo_data, Base64.DEFAULT);
            image_data = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            select_photo.setImageBitmap(image_data);
        } catch (NullPointerException e) {

        }

        select_photo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PetDetail.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        update_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PetRegistration.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor autoLogin = sharedPreferences.edit();
                autoLogin.clear();
                autoLogin.commit();
                Intent intent = new Intent(getActivity(), FirstStart.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        // Inflate the layout for this fragment
        return homeview;

    }

}