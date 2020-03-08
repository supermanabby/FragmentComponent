package com.example.gridviewcal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class CustomAdapter extends BaseAdapter {

    Context context;
    int logos[];
    LayoutInflater infilter;

    public CustomAdapter(Context applicationContext, int logos[]){
        this.context = applicationContext;
        this.logos = logos;
        infilter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public int getCount() {
        return logos.length;
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
      //  view = infilter.inflate(R.layout.activity_main);
        return null;
    }
}
