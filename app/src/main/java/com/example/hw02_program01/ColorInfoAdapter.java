package com.example.hw02_program01;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorInfoAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorInfoAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;
    }

    //how many things displaying in the listview
    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    //returns a ColorInfo object at the given position
    @Override
    public Object getItem(int position)
    {
        return listOfColors.get(position);
    }

    //where/what position did I click in the listview
    @Override
    public long getItemId(int position)
    {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.color_info_cell, null);
        }
        //find GUI elements
        TextView red = convertView.findViewById(R.id.tv_v_cell_red);
        TextView green = convertView.findViewById(R.id.tv_v_cell_green);
        TextView blue = convertView.findViewById(R.id.tv_v_cell_blue);
        TextView hex = convertView.findViewById(R.id.tv_v_cell_hex);


        //get data for the given color to fill into view that was created
        ColorInfo ci = listOfColors.get(position);

        //set GUI elements to colorinfo data
        red.setText("Red: " + ci.getRed());
        green.setText("Green: " + ci.getGreen());
        blue.setText("Blue: " + ci.getBlue());
        hex.setText("Hex: " + ci.getHex());
        convertView.setBackgroundColor(Color.rgb(ci.getRed(), ci.getGreen(), ci.getBlue()));

        if(ci.getRed() + ci.getGreen() + ci.getBlue() <= 380)
        {
            red.setTextColor(Color.rgb(255, 255,255));
            green.setTextColor(Color.rgb(255, 255,255));
            blue.setTextColor(Color.rgb(255, 255,255));
            hex.setTextColor(Color.rgb(255, 255,255));
        }
        else
        {
            red.setTextColor(Color.rgb(0, 0, 0));
            green.setTextColor(Color.rgb(0, 0, 0));
            blue.setTextColor(Color.rgb(0, 0, 0));
            hex.setTextColor(Color.rgb(0, 0, 0));
        }

        //return view that is built so we can add the row to the listview
        return convertView;
    }

}
