package com.farida.sprint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import java.util.List;

import static android.R.layout.simple_spinner_dropdown_item;

public class SprintTypeListAdapter extends BaseAdapter {

    private List<SprintType> sprintTypesList;

    public SprintTypeListAdapter(List<SprintType> sprintTypes) {
        this.sprintTypesList = sprintTypes;
    }

    @Override
    public int getCount() {
        return sprintTypesList.size();
    }

    @Override
    public Object getItem(int position) {
        return sprintTypesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return sprintTypesList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(simple_spinner_dropdown_item, parent, false);
        } else {
            view = convertView;
        }
        ((CheckedTextView) view).setText(sprintTypesList.get(position).getSprintTypeName());
        return view;
    }
}

