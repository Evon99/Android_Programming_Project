package com.example.petdiary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class RecordWarning extends Fragment {

    ListView listview;
    CustomChoiceListViewAdapter adapter;
    DiaryFragment diaryFragment;
    String date;
    SharedPreferences warning_values;
    Boolean warning_checking;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View Warningview = inflater.inflate(R.layout.warning_record, container, false);

        diaryFragment = new DiaryFragment();

        if (getArguments() != null) {
            date = getArguments().getString("date"); // 프래그먼트1에서 받아온 값 넣기
        }

        Toolbar toolbar = Warningview.findViewById(R.id.warning_toolbar);

        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); //뒤로가기
        actionBar.setTitle("이상 증상");

        // Adapter 생성
        adapter = new CustomChoiceListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) Warningview.findViewById(R.id.warning_listview);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem("눈이 이상하다.", "눈이 앞으로 튀어나와 있거나 눈이 아파보이고 보이지 않는 것 같다. ");
        // 두 번째 아이템 추가.
        adapter.addItem("귀가 이상하다.", "고개를 기울인 채 있다. 얼굴이 마비되어 있다.");
        // 세 번째 아이템 추가.
        adapter.addItem("코가 이상하다.", "코피가 많이 나고 멈추지 않는다.");
        adapter.addItem("구토를 한다.", "몇 차례 심하게 토했다.");
        adapter.addItem("혈변을 한다.", "변에 피가 묻어 나온다.");
        adapter.addItem("설사를 한다", "심한 설사를 한다.");
        adapter.addItem("배가 부어오른다.", "배가 급격하게 부어올랐다.");
        adapter.addItem("소변이 전혀 나오지 않는다.", "소변이 나오지 않거나, 보기 힘들어 한다.");
        adapter.addItem("열이 있다.", "열이 40도를 넘는다.");
        adapter.addItem("피부가 이상하다.", "피부나 점막이 노랗다.");
        adapter.addItem("호흡을 괴로워한다.", "호흡이 이상하고 입술과 혀가 보라색이거나 하얗다. 그리고 경련을 하거나 떨고 있다.");
        adapter.addItem("기침을 한다.", "기침이 심하다.");
        adapter.addItem("피를 토했다.", "피를 많이 토했다.");
        adapter.addItem("경련을 한다.", "경련이 몇 분 이상 계속됐다.");
        adapter.addItem("걷는 모습이 이상하다.", "다리를 든 채 바닥을 밟으려 하지 않는다.");

        warning_values = this.getActivity().getSharedPreferences(date, 0);
        for (int i = 0; i < adapter.getCount(); i++) {
            listview.setItemChecked(i,  warning_values.getBoolean("listview" + i, false));
        }

        return Warningview;
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar_finish, menu);
    }

    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home: {
                replaceFragment(diaryFragment);
                return true;
            }
            case R.id.finish: {
                warning_values = this.getActivity().getSharedPreferences(date, 0);
                SharedPreferences.Editor warning_check = warning_values.edit();

                for(int i = 0; i<listview.getCount(); i++) {
                    warning_check.putBoolean("listview" + i, listview.isItemChecked(i));
                }
                warning_check.commit();
                Toast.makeText(getActivity(), "등록 버튼 클릭됨", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_containers, fragment);
        fragmentTransaction.commit();
    }
}
