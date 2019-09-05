package com.example.agriapp_t.ui.custom_components;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CropSelectListAdapter extends BaseAdapter {


    private Context ctx = null;
    private ArrayList<String> list = null;

    private LayoutInflater mInflater = null;

    public CropSelectListAdapter(Activity activity, ArrayList<String> list) {
        this.ctx = activity;
        this.list = list;
        this.mInflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
