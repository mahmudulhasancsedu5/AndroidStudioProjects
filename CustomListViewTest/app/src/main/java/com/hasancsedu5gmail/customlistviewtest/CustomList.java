package com.hasancsedu5gmail.customlistviewtest;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by mahmud on 9/13/2017.
 */

public class CustomList extends ArrayAdapter<String> {

    private Activity mContext;
    private String mName[];
    private int mImageId[];
    public CustomList(Activity context, String[] name, int[] imageId) {
        super(context, R.layout.list_item, name);
        this.mContext = context;
        this.mName = name;
        this.mImageId =imageId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View rowView = mContext.getLayoutInflater().inflate(R.layout.list_item,null,true);

        TextView tvName = rowView.findViewById(R.id.text_item_name);
        ImageView ivImage = rowView.findViewById(R.id.img_item_image);

        tvName.setText(mName[position]);

        Picasso.with(mContext)
                .load(mImageId[position])
                .resize(100,160)
                .centerCrop()
                .into(ivImage);


        return rowView;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    private void loadImage(int possition, ImageView imageView){



    }
}
