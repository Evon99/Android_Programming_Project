package com.example.petdiary;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RecordPoop extends Fragment {

    ListView small_listview;
    ListView big_listview;
    PoopListViewAdapter small_adapter;
    PoopListViewAdapter big_adapter;
    DiaryFragment diaryFragment;
    String date;
    SharedPreferences small_poop_values;
    SharedPreferences big_poop_values;

    //스크롤 가능하게 만들기
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = (ListAdapter) listView.getAdapter();
        if (listAdapter == null) return;
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View Poopview = inflater.inflate(R.layout.poop_record, container, false);

        diaryFragment = new DiaryFragment();

        if (getArguments() != null) {
            date = getArguments().getString("date"); // 프래그먼트1에서 받아온 값 넣기
        }

        Toolbar toolbar = Poopview.findViewById(R.id.record_toolbar);

        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); //뒤로가기
        actionBar.setTitle("대소변");

        // Adapter 생성
        small_adapter = new PoopListViewAdapter();
        big_adapter = new PoopListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        small_listview = (ListView) Poopview.findViewById(R.id.poop_listview);
        small_listview.setAdapter(small_adapter);

        big_listview = (ListView) Poopview.findViewById(R.id.poop_listview2);
        big_listview.setAdapter(big_adapter);

        // 첫 번째 아이템 추가.
        small_adapter.addItem(getActivity().getDrawable(R.color.white),"투명한 무색 소변", "물을 많이 마신 상태");
        // 두 번째 아이템 추가.
        small_adapter.addItem(getActivity().getDrawable(R.color.yellow),"투명한 노란색 소변", "정상, 적절한 수분을 보유한 상태");
        // 세 번째 아이템 추가.
        small_adapter.addItem(getActivity().getDrawable(R.color.orange_yellow),"주황색과 어두운 노란색 소변", "물을 충분히 마시지 않은 상태이거나, 황달과 관련이" +
                " 높으며, 간이 손상되었거나 쓸개나 이자에 문제가 생겼을 확률이 높음");
        small_adapter.addItem(getActivity().getDrawable(R.color.red),"붉은색 소변", "요로 또는 방광에 일어나는 감염이나 결석, 종양에" +
                " 의한 방광염, 양파 중독 타이레놀 중독과 같은 적혈구가 파괴되는 질병과 관련이 높음.");
        small_adapter.addItem(getActivity().getDrawable(R.color.brown),"갈색 소변", "심각한 상태일 수 있음, 혈액세포 손상, 사고나" +
                " 외상으로인한 심각한 근육 손상, 독성 물질에 의한 체내 손상등을 의삼할 수 있으며, 기생충 감염 또는 간질환이 있거나 심각한 탈수상태일 수 있음.");

        // 첫 번째 아이템 추가.
        big_adapter.addItem(getActivity().getDrawable(R.color.normal_poop),"보통 변", "정상, 적절한 수분 보유");
        // 두 번째 아이템 추가.
        big_adapter.addItem(getActivity().getDrawable(R.color.water_poop),"묽은 변", "변의 경도는 수분 섭취량에 따라 일시적으로 대변이 무르거나" +
                " 딱딱할 수 있음");
        // 세 번째 아이템 추가.
        big_adapter.addItem(getActivity().getDrawable(R.color.normal_poop),"설사", "변의 경도는 수분 섭취량에 따라 수분 섭취량에 따라" +
                " 일시적으로 대변이 무를 수 있음, 하지만 지속적인 설사는 장에 세균셩 감염이 원인일 수 있으므로 가까운 동물 병원에 내원해야함");
        big_adapter.addItem(getActivity().getDrawable(R.color.hard_poop),"짙고 딱딱한 변", "변비 기미가 있거나, 신장에 문제가 있을 경우에" +
                " 볼 수 있음, 또한 사료양이 적을 때도 나타날 수 있음");
        big_adapter.addItem(getActivity().getDrawable(R.color.red_poop),"붉은색 변", "소화기, 특히 상복부 소화기에 출혈이 있음을" +
                " 알 수 있는 경우로 빠른 시간 내로 수의사의 진찰을 받는 것이 중요");
        big_adapter.addItem(getActivity().getDrawable(R.color.black_poop),"검은색 변", "상부 소화기의 출혈이 생겼거나, 수분이 부족해" +
                " 나타날 수 있음, 의심이 되는 경우 수의사의 진찰을 받는 것이 중요");
        big_adapter.addItem(getActivity().getDrawable(R.color.normal_poop),"하얀색 점이 있는 변", "변에 보이는 하얀색 점은 기생충 감염을" +
                " 의미할 수 있으므로 정확한 진단이 필요");


        setListViewHeightBasedOnChildren(small_listview);
        setListViewHeightBasedOnChildren(big_listview);

        small_poop_values = this.getActivity().getSharedPreferences(date, 0);
        for (int i = 0; i < small_adapter.getCount(); i++) {
            small_listview.setItemChecked(i,  small_poop_values.getBoolean("small_listview" + i, false));
        }

        big_poop_values = this.getActivity().getSharedPreferences(date, 0);
        for (int i = 0; i < big_adapter.getCount(); i++) {
            big_listview.setItemChecked(i,  big_poop_values.getBoolean("big_listview" + i, false));
        }

        return Poopview;
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
                small_poop_values = this.getActivity().getSharedPreferences(date, 0);
                SharedPreferences.Editor small_poop_check = small_poop_values.edit();

                big_poop_values = this.getActivity().getSharedPreferences(date, 0);
                SharedPreferences.Editor big_poop_check = small_poop_values.edit();

                for(int i = 0; i< small_listview.getCount(); i++) {
                    small_poop_check.putBoolean("small_listview" + i, small_listview.isItemChecked(i));
                }

                for(int i = 0; i< big_listview.getCount(); i++) {
                    big_poop_check.putBoolean("big_listview" + i, big_listview.isItemChecked(i));
                }

                small_poop_check.commit();
                big_poop_check.commit();
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
