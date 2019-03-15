package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView icon_home;
    private ImageView icon_menu;
    private RelativeLayout level1;
    private RelativeLayout level2;
    private RelativeLayout level3;


    /**
     * 是否显示第三圆环
     * true:显示
     * false隐藏
     */
    private boolean isShowLevel3 = true;

    /**
     * 是否显示第二圆环
     * true:显示
     * false隐藏
     */
    private boolean isShowLevel2 = true;


    /**
     * 是否显示第一圆环
     * true:显示
     * false隐藏
     */
    private boolean isShowLevel1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icon_home = findViewById(R.id.icon_home);
        icon_menu = findViewById(R.id.icon_menu);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        //设置点击事件
        icon_home.setOnClickListener(this);
        icon_menu.setOnClickListener(this);
        level1.setOnClickListener(this);
        level2.setOnClickListener(this);
        level3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.level1:
                Toast.makeText(MainActivity.this, "level1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.level2:
                Toast.makeText(MainActivity.this, "level2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.level3:
                Toast.makeText(MainActivity.this, "level3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icon_home://home
             //1.如果二级菜单和三级菜单都可见，一起消失，2二级菜菜单不可见，让他可见
             if(isShowLevel2){
                 isShowLevel2 =false;
                 Tools.hideView(level2);
                 if(isShowLevel3){
                     isShowLevel3 = false;
                     Tools.hideView(level3,200);
                 }
             }else {
                 isShowLevel2 = true;
                 Tools.showView(level2);
             }



                break;
            case R.id.icon_menu://菜单
                //三级可见，三级消失
                if(isShowLevel3){
                    isShowLevel3 =false;
                    Tools.hideView(level3);
                }else {
                    isShowLevel3 =true;
                    Tools.showView(level3);
                }

                break;


        }
    }
}
