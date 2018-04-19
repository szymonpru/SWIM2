package com.example.turli.swim2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.turli.swim2.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by turli on 12.04.2018.
 */

public class ImagesAdapter extends BaseAdapter {

    private Context context;

    public ImagesAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
    }

    private ArrayList<Integer> images;

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int i) {
        return images.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if(view == null) {
            gridView = inflater.inflate(R.layout.grid_image, null);
            ImageView imageView = gridView.findViewById(R.id.image_view_grid);
            imageView.setImageResource(images.get(i));
        } else {
            gridView = view;
        }

        return gridView;
    }
}
