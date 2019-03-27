package com.example.myapplication.day2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.TogglebuttonActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_youkuu,tv_banner,tv_popwidow,tv_toglebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv_youkuu = findViewById(R.id.tv_youkuu);
        tv_banner = findViewById(R.id.tv_banner);
        tv_popwidow = findViewById(R.id.tv_popwidow);
        tv_toglebutton = findViewById(R.id.tv_toglebutton);

        tv_youkuu.setOnClickListener(this);
        tv_banner.setOnClickListener(this);
        tv_popwidow.setOnClickListener(this);
        tv_toglebutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.tv_youkuu:
//                   Log.e("======","0000000000000");
                   startActivity(new Intent(HomeActivity.this, MainActivity.class));
               break;
               case R.id.tv_banner:
                   startActivity(new Intent(HomeActivity.this, Main4Activity.class));
                   break;
               case R.id.tv_popwidow:
                   startActivity(new Intent(HomeActivity.this, PopActivity.class));
                   break;
               case R.id.tv_toglebutton:
                   startActivity(new Intent(HomeActivity.this, TogglebuttonActivity.class));
                   break;
           }
    }
}
