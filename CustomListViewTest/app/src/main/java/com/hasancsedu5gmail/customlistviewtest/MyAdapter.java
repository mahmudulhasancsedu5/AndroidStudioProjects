package com.hasancsedu5gmail.customlistviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by mahmud on 9/15/2017.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mName;
    private int[] mImageId;
    LayoutInflater inflater;


    public MyAdapter(Context context,String[] name,int[] imageId) {
        this.mContext = context;
        this.mName = name;
        this.mImageId = imageId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view != null){
            holder = (ViewHolder) view.getTag();

        }else{

            view = inflater.inflate(R.layout.list_item,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.tvCastName.setText(mName[i]);

        Picasso.with(mContext)
                .load(mImageId[i])
                .resize(100,100)
                .centerCrop()
                .transform(new CropCircleTransformation())
                .into(holder.ivCastImage);

        return view;
    }

    static class ViewHolder{
        @BindView(R.id.img_item_image)ImageView ivCastImage;
        @BindView(R.id.text_item_name)TextView tvCastName;

        public ViewHolder(View view) {
            
            ButterKnife.bind(this,view);
        }
    }
}


