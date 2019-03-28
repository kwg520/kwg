package com.example.myapplication.day2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.myapplication.R;

public class myselfTogleButton extends View {
    private Bitmap backgroundBitmap;
    private Bitmap togleBitmap ;
    private Paint paint ;
    private  int leftmax ;
    private float slideleft;
    private boolean isOpen = false;
    private float startX;
    private float lastX;

    public myselfTogleButton(Context context,AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        paint  =new Paint();
        paint.setAntiAlias(true);//抗锯齿
        backgroundBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.switch_background);
        togleBitmap =  BitmapFactory.decodeResource(getResources(),R.drawable.slide_button);
        leftmax = backgroundBitmap.getWidth() - togleBitmap.getWidth();
        setOnClickListener(this);
    }

    private boolean isEnableClick = true;
    private void setOnClickListener(myselfTogleButton myselfTogleButton) {
         if(isEnableClick) {
             isOpen = !isOpen;
             flushView();
         }


    }

    private void flushView() {
        if(isOpen){
            slideleft = leftmax;
        }else {
            slideleft = 0;
        }
        invalidate();//会导致onDraw()执行
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(backgroundBitmap.getWidth(),backgroundBitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(backgroundBitmap,0,0,paint);
        canvas.drawBitmap(togleBitmap,slideleft,0,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

     switch (event.getAction()){
         case MotionEvent.ACTION_DOWN:
             lastX =startX=event.getX();
             isEnableClick =true;
             break;
         case MotionEvent.ACTION_MOVE:
             float endx = event.getX();
             float distance = endx -startX;
             slideleft += distance;
             if(slideleft<0){
                 slideleft = 0;
             }else if(slideleft>leftmax){
                 slideleft = leftmax;
             }

             //4.屏蔽非法值
             //5.刷新
             invalidate();
             if(Math.abs(endx - lastX) > 5){  //Math.abs(x) 函数返回指定数字 “x“ 的绝对值
                 //滑动
                 isEnableClick = false;
             }
             //6.数据还原
             startX = event.getX();

             break;
         case MotionEvent.ACTION_UP:
             if(!isEnableClick){
                 if(slideleft > leftmax/2){

                     //显示按钮开
                     isOpen = true;
                 }else{

                     isOpen = false;

                 }
                 flushView();
             }
             break;
     }

        return true;
    }
}
