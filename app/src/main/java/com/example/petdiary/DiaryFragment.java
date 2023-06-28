package com.example.petdiary;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class DiaryFragment extends Fragment {


    Button warning_button;
    Button poop_button;
    Button vomite_button;
    CalendarView calendarView;
    String selected_date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Diaryview = inflater.inflate(R.layout.fragment_diary, container, false);

        warning_button = Diaryview.findViewById(R.id.warning_button);
        poop_button = Diaryview.findViewById(R.id.poop_button);
        vomite_button = Diaryview.findViewById(R.id.vomite_button);
        calendarView = Diaryview.findViewById(R.id.calendarview);
        Toolbar toolbar = Diaryview.findViewById(R.id.toolbar);
        MainActivity activity = (MainActivity) getActivity();


        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true); //뒤로가기
        actionBar.setTitle("건강 기록");


        warning_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("date", selected_date);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                RecordWarning WarningFragment = new RecordWarning();//프래그먼트2 선언
                WarningFragment.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.fragment_containers, WarningFragment);
                transaction.commit();
            }
        });

        poop_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("date", selected_date);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                RecordPoop PoopFragment = new RecordPoop();//프래그먼트2 선언
                PoopFragment.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.fragment_containers, PoopFragment);
                transaction.commit();
            }
        });

        vomite_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("date", selected_date);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                RecordVomite VomiteFragment = new RecordVomite();//프래그먼트2 선언
                VomiteFragment.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.fragment_containers, VomiteFragment);
                transaction.commit();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayofMonth) {
                selected_date = year  + "-" + (month+1) + "-" + dayofMonth;
                Toast.makeText(activity, selected_date, Toast.LENGTH_SHORT).show();
            }
        });
        return Diaryview;
    }

}