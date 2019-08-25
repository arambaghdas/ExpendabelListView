package com.call.myapplication;

import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private List<TitleObject> expandableListTitle;
    private HashMap<TitleObject, List<SubTitleObject>> expandableListDetail;

    public ExpandableListViewAdapter(List<TitleObject> expandableListTitle,
                                     HashMap<TitleObject, List<SubTitleObject>> expandableListDetail) {
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        if (expandableListDetail.get(this.expandableListTitle.get(listPosition)) == null)
            return null;
        else
            return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final SubTitleObject titleObject = (SubTitleObject) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row_child, null);
        }

        if (titleObject != null) {
            TextView textView1 = convertView.findViewById(R.id.text1);
            textView1.setText(titleObject.getTitle());
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        if (this.expandableListDetail.get(this.expandableListTitle.get(listPosition)) == null)
            return 0;
        else
            return this.expandableListDetail.get(this.expandableListTitle.get(listPosition)).size();

    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
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
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}