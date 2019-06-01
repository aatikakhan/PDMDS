package com.example.parkinson.java.adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.parkinson.java.Common;
import com.example.parkinson.R;

import java.util.List;


public class Display_Adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    List<Common> pendingItems;

    public Display_Adapter(Activity activity, List<Common> pendingItems) {
        this.activity = activity;
        this.pendingItems = pendingItems;
    }


    @Override
    public int getCount() {
        return pendingItems.size();//return 0;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.user_complaint_listitem, null);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView flat = (TextView) convertView.findViewById(R.id.flat);


        Common m = pendingItems.get(position);

        title.setText(m.para1);
        flat.setText(" "+m.para2);


        return convertView;
    }


}
