package com.example.app06.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app06.R;

import java.util.List;

public class PlanetListAdapter extends BaseAdapter {
    private List<Planet> arrayData;
    private Context context;

    public PlanetListAdapter(Context ctx,List<Planet> planets){
        super();
        this.arrayData=planets;
        this.context=ctx;
    }
    @Override
    public int getCount() {
        return arrayData.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView ==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_row_layout, null);
        }
        Planet p =arrayData.get(position);
        ((TextView)convertView.findViewById(R.id.lbl_name)).setText(p.getName());
        ((TextView)convertView.findViewById(R.id.lbl_gravity)).setText(p.getGravity()+"");
        ((TextView)convertView.findViewById(R.id.lbl_diameter)).setText(p.getDiameter()+"");

        return convertView;

    }
}
