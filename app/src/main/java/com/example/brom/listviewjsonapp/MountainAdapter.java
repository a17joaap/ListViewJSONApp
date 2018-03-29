package com.example.brom.listviewjsonapp;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MountainAdapter extends ArrayAdapter<Mountain> {

    private Context context;
    private List<Mountain> mtnList = new ArrayList<>();

    public MountainAdapter(@NonNull Context c, ArrayList<Mountain> list) {
        super(c, 0 , list);
        context = c;
        mtnList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item_textview,parent,false);

        Mountain currentMountain = mtnList.get(position);

        TextView name = listItem.findViewById(R.id.mtnName);
        name.setText(currentMountain.name);

        TextView location = listItem.findViewById(R.id.mtnLoc);
        location.setText(currentMountain.location);

        TextView height = listItem.findViewById(R.id.mtnHeight);
        height.setText(currentMountain.height);

        return listItem;
    }
}
