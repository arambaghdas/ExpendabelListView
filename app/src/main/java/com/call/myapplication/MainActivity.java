package com.call.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TitleObject> listDataGroup = new ArrayList<>();
        HashMap<TitleObject, List<SubTitleObject>> expandableListDetail = new HashMap<TitleObject, List<SubTitleObject>>();

        TitleObject titleObject = new TitleObject();
        titleObject.setTitle("Text1");
        titleObject.setShow(true);
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

        SubTitleObject subTitleObject1 = new SubTitleObject();
        subTitleObject1.setTitle("ddddd");

        SubTitleObject subTitleObject2 = new SubTitleObject();
        subTitleObject2.setTitle("sss");

        SubTitleObject subTitleObject3 = new SubTitleObject();
        subTitleObject3.setTitle("sssssss");


        List<SubTitleObject> subTitleObjectList = new ArrayList<>();
        subTitleObjectList.add(subTitleObject1);
        subTitleObjectList.add(subTitleObject2);
        subTitleObjectList.add(subTitleObject3);

        expandableListDetail.put(titleObject, subTitleObjectList);
        expandableListDetail.put(titleObject1, null);
        expandableListDetail.put(titleObject2, null);

        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        ExpandableListViewAdapter expandableListViewAdapter = new ExpandableListViewAdapter(listDataGroup, expandableListDetail);
        expandableListView.setAdapter(expandableListViewAdapter);
    }

}
