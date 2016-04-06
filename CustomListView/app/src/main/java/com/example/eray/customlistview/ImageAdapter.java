package com.example.eray.customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.eray.customlistview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends ArrayAdapter<String> {

    List<String> items;

    /**
     * It provides the default implementation of all methods in an event listener interface
     * @param context This is the first parameter to onCreate method
     * @param resource This is the first parameter to onCreate method
     * @param itemsThis is the first parameter to onCreate method
     * return Nothing
     */
    public ImageAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.items = items;
    }

    /**
     * This method provides getting the view according to position
     * @param position This is the first parameter to onCreate method
     * @param convertView This is the first parameter to onCreate method
     * @param parent This is the first parameter to onCreate method
     * @return type is view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
          convertView = inflater.inflate(R.layout.newspaper_images, null);
        }

        Picasso.with(getContext())
                .load(items.get(position))
                .into((ImageView) convertView);
    Log.d("picasso", "Picasso yukluyo");

      //  this.notifyDataSetChanged();
        return convertView;
    }
}