package com.mic.joke;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mic.xwidget.recyclerview.adapter.ViewHolder;


/**
 * Created by Darren on 2016/12/28.
 * Email: 240336124@qq.com
 * Description:
 */

public class GlideImageLoader extends ViewHolder.HolderImageLoader {

    public GlideImageLoader(String imagePath) {
        super(imagePath);
    }

    @Override
    public void displayImage(Context context, ImageView imageView, String imagePath) {
        // Glide 加载图片
        //Glide.with(context).load(imagePath)(R.drawable.ic_discovery_default_channel).into(imageView);
    }
}
