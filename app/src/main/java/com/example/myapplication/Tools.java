package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;

/**
 * 作者：kwg on 2016/5/14 10:23
 * 微信：kwg133
 * QQ号：1020296242
 * 作用：显示和隐藏指定控件
 */
public class Tools {

    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    public static void showView(ViewGroup view, int x) {

        //利用的补间动画
        RotateAnimation ra  = new RotateAnimation(180,360,view.getWidth()/2,view.getHeight());
        ra.setStartOffset(200);
        ra.setDuration(500);
        ra.setFillAfter(true);

        view.startAnimation(ra);
        for (int i = 0; i <view.getChildCount() ; i++) {
            view.getChildAt(i).setEnabled(true);
//            view.getChildAt(i).setClickable(true);
        }


     /*
         利用的属性动画完成
       ObjectAnimator oa = ObjectAnimator.ofFloat(view,"rotation",180,360);
         oa.setDuration(500);
         oa.setStartDelay(x);
         oa.start();
         view.setPivotX(view.getWidth()/2);
         view.setPivotY(view.getHeight());*/


    }

    public static void hideView(ViewGroup view, int x) {

        for (int i = 0; i < view.getChildCount(); i++) {
            view.getChildAt(i).setEnabled(false);
//            view.getChildAt(i).setClickable(false);
        }
        //利用的补间动画
        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
        ra.setStartOffset(200);
        ra.setDuration(500);
        ra.setFillAfter(true);
        view.startAnimation(ra);
    }


       /*
       利用的属性动画完成
       ObjectAnimator oa = ObjectAnimator.ofFloat(view,"rotation",0,180);
        oa.setDuration(500);
        oa.setStartDelay(x);
        oa.start();
        view.setPivotX(view.getWidth()/2);
        view.setPivotY(view.getHeight());*/



}
