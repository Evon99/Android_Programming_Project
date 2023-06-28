package com.example.petdiary;

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
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RecordVomite extends Fragment{

    ListView listview;
    VomiteListViewAdapter adapter;
    DiaryFragment diaryFragment;
    String date;
    SharedPreferences vomite_values;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View VomiteView = inflater.inflate(R.layout.vomite_record, container, false);

        diaryFragment = new DiaryFragment();

        if (getArguments() != null) {
            date = getArguments().getString("date"); // 프래그먼트1에서 받아온 값 넣기
        }

        Toolbar toolbar = VomiteView.findViewById(R.id.vomite_toolbar);

        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); //뒤로가기
        actionBar.setTitle("구토");

        // Adapter 생성
        adapter = new VomiteListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) VomiteView.findViewById(R.id.vomite_listview);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(getActivity().getDrawable(R.drawable.hairball),"헤어볼 구토", "그루밍으로 위와 소장안에 털이 뭉칠 수" +
                " 있음, 털 양이 많을 경우 뱃속에서 엉켜 헤어볼 구토를 하는 것입니다. 일반적으로 배변으로 배출되지만, 구토 이외 다른 증상이 없고 한 달에 1~2회" +
                " 정도라면 자연스러운 생리현상으로 봐도 됨. 식이섬유 함량이 높은 사료를 먹이거나 관련 영양제를 급여할 경우 헤어볼 구토를 줄이는 것에 도움이 됨");
        // 두 번째 아이템 추가.
        adapter.addItem(getActivity().getDrawable(R.color.white),"투명한 무색 구토", "투명한 구토는 물이나, 위액, 침이 역류한 것입니다." +
                " 한 번 정도 증상이 보이는 것은 문제가 없을 경우가 많으니 하루 정도 지켜보기");
        // 세 번째 아이템 추가.
        adapter.addItem(getActivity().getDrawable(R.drawable.bubble),"흰색 거품이 섞인 구토", "투명한 토가 역류할 때 공기를 삼켜 거품이 된 것." +
                " 큰 문제가 없는 경우가 많으니 지켜보기");
        adapter.addItem(getActivity().getDrawable(R.drawable.pizza),"음식이 섞인 구토", "사료나 간식을 급하게 먹이거나, 과식하는 경우" +
                " 소화불량으로 구토를 하는 경우가 있음. 소화가 잘되게 작게 잘라 주거나 사료를 물에 불려 급여해주기.");
        adapter.addItem(getActivity().getDrawable(R.color.water_poop),"노란색 구토", "주로 불규칙한 식습관과 식사 간격이 문제가 될때 발생," +
                " 공복의 상태가 길어질 경우 담즙(소화액)이 위를 자극해 거품과 함께 구토하는 경우가 많음");
        adapter.addItem(getActivity().getDrawable(R.drawable.leaf),"잎사귀가 섞인 초록색 구토", "위장상태가 나쁠 때 일부러 잎사귀를 먹고 위" +
                " 속을 토해 냄. 구토 후 기력이 없진 않은지 지켜보기. 이상이 있을 경우 바로 병원에 데려갈 것");
        adapter.addItem(getActivity().getDrawable(R.color.pink),"분홍색 구토", "입 안 또는 식도, 위, 장에 부분적인 출혈이 생겼을 수" +
                " 있으니 지켜보기. 가끔 일어나는 증상일 경우에는 문제가 없을 수 있으나 여러 번 반복하여 분홍색 구토를 하는 경우 병원에서 진단 받기");
        adapter.addItem(getActivity().getDrawable(R.color.hard_poop),"짙은 갈색 구토", "상부 소화기에 출혈이 생긴 경우가 있으며," +
                " 질병을 의심할 수 있음. 출혈이 많은 경우 위험한 상황이 발생할 수 있어, 반드시 병원에 방문하여서 진료받기");
        adapter.addItem(getActivity().getDrawable(R.color.deep_green),"녹색 구토", "주로 식습관과 식사 간격이 문제가 될 때 발생하며," +
                "공복의 상태가 길어질 경우 담즙(소화액)이 위를 자극해 거품과 함께 구토하는 경우가 많음. 반복적인 녹색 구토는 췌장염이나 장폐색 같은 응급 질환과 관련이" +
                " 있을 가능성이 있으므로 반드시 병원에 내원하셔야 합니다.");
        adapter.addItem(getActivity().getDrawable(R.drawable.bacteria),"이물질이 섞인 구토", "이물질을 토해낸 경우 이물질이 역류하여" +
                " 장이나 위에 상처가 생길 수 있습니다. 구토하는 도중 식도가 막히면 위험한 상황이 발생할 수 있으니 증상이 보인다면 반드시 병원에 방문하여 진료받기");
        adapter.addItem(getActivity().getDrawable(R.color.deep_red),"붉은색 구토", "입 속, 식도, 위, 장에 출혈이 크게 생겼을 수 있음." +
                " 출혈량이 많다면 위험한 상황일 수 있어 병원에 꼭 내원하기");

        vomite_values = this.getActivity().getSharedPreferences(date, 0);
        for (int i = 0; i < adapter.getCount(); i++) {
            listview.setItemChecked(i,  vomite_values.getBoolean("vomite_listview" + i, false));
        }

        return VomiteView;
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
                vomite_values = this.getActivity().getSharedPreferences(date, 0);
                SharedPreferences.Editor vomite_check = vomite_values.edit();

                for(int i = 0; i<listview.getCount(); i++) {
                    vomite_check.putBoolean("vomite_listview" + i, listview.isItemChecked(i));
                }
                vomite_check.commit();
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
