package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.day2.MyToggleButton;

public class TogglebuttonActivity extends AppCompatActivity {


    MyToggleButton myToggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_togglebutton);
        myToggleButton = findViewById(R.id.togle_about);
        myToggleButton.getWidth();
        myToggleButton.getHeight();
        myToggleButton.post(new Runnable() {
            @Override
            public void run() {
                Log.e("=======","getWidth()"+myToggleButton.getWidth()+"---"+"getHeight()"+myToggleButton.getHeight());
            }
        });

    }
}
