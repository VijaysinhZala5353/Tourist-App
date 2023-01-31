package com.example.touristapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class placeAdapter extends BaseAdapter {
    private ArrayList<Place> tempPlaceList;
    private LayoutInflater inflater;

    public placeAdapter(Context context, ArrayList<Place> tempPlaceList)
    {
        this.tempPlaceList=tempPlaceList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tempPlaceList.size();
    }

    @Override
    public Object getItem(int i) {
        return tempPlaceList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            view=inflater.inflate(R.layout.place_list,null);
            holder=new ViewHolder();
            holder.name=view.findViewById(R.id.tvPlace);
            holder.price=view.findViewById(R.id.tvPrice);
            holder.img=view.findViewById(R.id.placeImg);
            view.setTag(holder);
        }
        else
            holder=(ViewHolder) view.getTag();
        holder.name.setText(tempPlaceList.get(i).getPlaceName());
        holder.price.setText(String.valueOf(tempPlaceList.get(i).getPlacePrice()));
        holder.img.setImageResource(tempPlaceList.get(i).getPlaceImage());
        return view;
    }
    static class ViewHolder{
        private TextView name,price;
        private ImageView img;
    }
}
