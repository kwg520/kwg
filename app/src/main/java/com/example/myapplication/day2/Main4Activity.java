package com.example.myapplication.day2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {

    private final String TAG = Main4Activity.this.getClass().getSimpleName() ;
    private ViewPager vp;

     private int [] ids = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.a,R.drawable.d};
     private List<ImageView> imageViews ;
     MyPgAdapter adapter ;
     private String[] titles = new String[]{
             "你是小甲","你是小明","你是小刚","你是小飞","你是小云"
     };
     private LinearLayout llPonits;
     private TextView tvTitle ;

     private int previous = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        vp = findViewById(R.id.viewpager);
        llPonits = findViewById(R.id.ll_point_group);
        tvTitle = findViewById(R.id.tv_title);
        imageViews  =new ArrayList<>();
        for (int i = 0; i <ids.length ; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            imageViews.add(imageView);

            //添加点的数量
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.bg_point_selctor);
            LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(20,20);

            if(i==0){
                point.setEnabled(true);
            }else{
                params.leftMargin = 8;
                point.setEnabled(false);
            }
            point.setLayoutParams(params);
            llPonits.addView(point);


        }
        adapter = new MyPgAdapter(this,imageViews);
        vp.setAdapter(adapter);
        //先设置适配器后设置位置，否则则不会生效，切记
        tvTitle.setText(titles[previous]);
        int item = Integer.MAX_VALUE/2 - Integer.MAX_VALUE/2%imageViews.size();
        vp.setCurrentItem(item);

         vp.addOnPageChangeListener(new MyVplistenr());


    }


    private class MyVplistenr implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int i, float v, int i1) {//当前的页面，滑动的百分比，屏幕上滑动的像素

        }

        @Override
        public void onPageSelected(int position) {   //当某个页面被选中

            int realpositon = position%imageViews.size();

            tvTitle.setText(titles[realpositon]);

            llPonits.getChildAt(realpositon).setEnabled(true);
            llPonits.getChildAt(previous).setEnabled(false);
            previous = realpositon ;

        }

        /**
         当页面滚动状态变化的时候回调这个方法
         静止->滑动
         滑动-->静止
         静止-->拖拽

         */

        @Override
        public void onPageScrollStateChanged(int i) {


        }
    }
}
