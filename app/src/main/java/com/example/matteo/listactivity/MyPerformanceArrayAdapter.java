package com.example.matteo.listactivity;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Matteo on 18/03/2015.
 */
public class MyPerformanceArrayAdapter extends ArrayAdapter<String>
{
    private final Activity context;
    private final String[] values;

    static class ViewHolder
    {
        public TextView text;
        public ImageView image;
    }

    public MyPerformanceArrayAdapter(Activity context, String[] values)
    {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView = convertView;

        if(rowView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.rowlayout, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.label);
            viewHolder.image = (ImageView) rowView.findViewById(R.id.icon);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        String s = values[position];
        holder.text.setText(s);

        if (s.startsWith("Windows7") || s.startsWith("iPhone") || s.startsWith("Solaris"))
        {
            holder.image.setImageResource(R.drawable.no);
        }
        else
        {
            holder.image.setImageResource(R.drawable.yes);
        }

        return rowView;
    }
}
