package com.example.myapplication.day2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class MyPgAdapter extends PagerAdapter {

    private Context mcontext;
    private List<ImageView> imageViews ;

    public MyPgAdapter(Context mcontext, List<ImageView> imageViews) {
        this.mcontext = mcontext;
        this.imageViews = imageViews;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        int realposition = position%imageViews.size();
      final   ImageView imageView = imageViews.get(realposition);
       container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
}
