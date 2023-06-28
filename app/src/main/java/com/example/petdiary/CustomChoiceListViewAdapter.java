package com.example.petdiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomChoiceListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<WarningListViewItem> listViewItemList = new ArrayList<WarningListViewItem>() ;

    // ListViewAdapter의 생성자
    public CustomChoiceListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.warning_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        //ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView title_textTextView = (TextView) convertView.findViewById(R.id.title_textView) ;
        TextView warning_textTextView = (TextView) convertView.findViewById(R.id.warning_textView) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        WarningListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        //iconImageView.setImageDrawable(listViewItem.getIcon());
        title_textTextView.setText(listViewItem.getTitle_text());
        warning_textTextView.setText(listViewItem.getWarning_text());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String title_text, String warning_text) {
        WarningListViewItem item = new WarningListViewItem();

        //item.setIcon(icon);
        item.setTitle_text(title_text);
        item.setWarning_text(warning_text);

        listViewItemList.add(item);
    }

}
