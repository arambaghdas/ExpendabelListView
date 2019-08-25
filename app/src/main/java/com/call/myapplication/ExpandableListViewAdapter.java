package com.call.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private List<TitleObject> listDataGroup;
    private ExpandableListViewAdapter.OnItemClicked onClick;

    public interface OnItemClicked {
        void onItemClick(int number);
    }

    public ExpandableListViewAdapter(List<TitleObject> listDataGroup) {
        this.listDataGroup = listDataGroup;
    }

    public void setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataGroup.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final TitleObject titleObject = (TitleObject) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row_child, null);
        }

        LinearLayout linerLayout = convertView.findViewById(R.id.linerLayout);
        TextView textView1 = convertView.findViewById(R.id.text1);
        TextView textView2 = convertView.findViewById(R.id.text2);
        TextView textView3 = convertView.findViewById(R.id.text3);

        if (titleObject.show) {
            linerLayout.setVisibility(View.VISIBLE);
            textView1.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            textView1.setText(titleObject.getStringArrayList().get(0));
            textView2.setText(titleObject.getStringArrayList().get(1));
            textView3.setText(titleObject.getStringArrayList().get(2));
        } else {
            linerLayout.setVisibility(View.GONE);
            textView1.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);
            textView3.setVisibility(View.GONE);
        }

        textView1.setOnClickListener(v -> {
            onClick.onItemClick(0);
        });

        textView2.setOnClickListener(v -> {
            onClick.onItemClick(1);
        });

        textView3.setOnClickListener(v -> {
            onClick.onItemClick(2);
        });

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }
    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataGroup.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataGroup.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        final TitleObject titleObject = (TitleObject) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row_group, null);
        }

        TextView tvAddress = convertView.findViewById(R.id.menuTextView);
        ImageView ivIcon = convertView.findViewById(R.id.menuImageView);
        tvAddress.setText(titleObject.title);
        ivIcon.setImageResource(titleObject.drawable);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}