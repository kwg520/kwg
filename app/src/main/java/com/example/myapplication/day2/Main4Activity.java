package com.example.myapplication.day2;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {

    private final String TAG = Main4Activity.this.getClass().getSimpleName() ;
    private ViewPager vp;

     private int [] ids = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.a,R.drawable.d};
     private List<ImageView> imageViews ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        vp = findViewById(R.id.viewpager);
        imageViews  =new ArrayList<>();
        for (int i = 0; i <ids.length ; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            imageViews.add(imageView);
        }

        vp.setAdapter(new myPageAdapter());



    }


    private class myPageAdapter extends PagerAdapter {
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            ImageView imageView  = imageViews.get(position);
            container.addView(imageView);
            Log.e(TAG,"imageView--"+imageView+"position--"+position);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            Log.e(TAG,"object--"+object+"position--"+position);
               container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view==o;
        }
    }
}
