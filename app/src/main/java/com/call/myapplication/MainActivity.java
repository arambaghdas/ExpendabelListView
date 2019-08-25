package com.call.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ExpandableListViewAdapter.OnItemClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TitleObject> listDataGroup = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("SubItem1");
        stringArrayList.add("SubItem2");
        stringArrayList.add("SubItem3");

        TitleObject titleObject = new TitleObject();
        titleObject.setTitle("Text1");
        titleObject.setShow(true);
        titleObject.setStringArrayList(stringArrayList);
        titleObject.setDrawable(R.drawable.ic_access_time_black_24dp);

        TitleObject titleObject1 = new TitleObject();
        titleObject1.setTitle("Text2");
        titleObject1.setShow(false);
        titleObject1.setDrawable(R.drawable.ic_settings_black_24dp);

        TitleObject titleObject2 = new TitleObject();
        titleObject2.setTitle("Text3");
        titleObject2.setShow(false);
        titleObject2.setDrawable(R.drawable.ic_report_black_24dp);

        listDataGroup.add(titleObject);
        listDataGroup.add(titleObject1);
        listDataGroup.add(titleObject2);
        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        ExpandableListViewAdapter expandableListViewAdapter = new ExpandableListViewAdapter(listDataGroup);
        expandableListView.setAdapter(expandableListViewAdapter);
        expandableListViewAdapter.setOnClick(MainActivity.this);
    }

    @Override
    public void onItemClick(int number) {
        Toast.makeText(this, String.valueOf(number),
                Toast.LENGTH_LONG).show();
    }
}
