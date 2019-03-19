package com.example.myapplication.day2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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
      imageView.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              switch (event.getAction()){
                  case MotionEvent.ACTION_DOWN:
                    Main4Activity.handler.removeCallbacksAndMessages(null);
                      break;

                  case MotionEvent.ACTION_MOVE:

                      break;
                  case MotionEvent.ACTION_UP:
                      Main4Activity.handler.sendEmptyMessageDelayed(0,3000);
                      break;

              }

              return false;
          }
      });



      imageView.setTag(position);
      imageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            int position =   (int)v.getTag()%imageViews.size();
            String text = Main4Activity.titles[position];
            Toast.makeText(mcontext, "text=="+text, Toast.LENGTH_SHORT).show();
          }
      });

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
