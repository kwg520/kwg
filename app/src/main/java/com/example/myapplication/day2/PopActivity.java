package com.example.myapplication.day2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PopActivity extends AppCompatActivity {
    EditText editText ;
    ImageView  ivdown;

    PopupWindow popupWindow ;
    private RecyclerView list;

    List<String> titles;
    ImageView iv_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        iv_delete = findViewById(R.id.iv_delete);
        editText = findViewById(R.id.et_input);
        ivdown = findViewById(R.id.iv_down_arrow);
        list= new RecyclerView(this);
        titles = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            titles.add(i+"我是一个框框---");
        }

        iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new MyRecycleAdapter());
        list.setBackgroundResource(R.drawable.listview_background);
        ivdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("===========","onClick");
                if(popupWindow==null){
                    popupWindow = new PopupWindow();
                    popupWindow.setWidth(editText.getWidth());
                    int height = DensityUtil.dip2px(PopActivity.this,200);//dp->px
                    Toast.makeText(PopActivity.this,"height=="+height,Toast.LENGTH_SHORT).show();
                    popupWindow.setHeight(height);//
                    popupWindow.setContentView(list);
                    popupWindow.setFocusable(true);
//                    popupWindow.setOutsideTouchable(true);
//                    popupWindow.setTouchable(true);
//                    popupWindow.update();
                }
                popupWindow.showAsDropDown(editText,0,0);
            }
        });

    }

     class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
         @NonNull
         @Override
         public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
             View view = ViewGroup.inflate(PopActivity.this,R.layout.item_about,null);
             return new MyViewHolder(view);
         }

         @Override
         public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {

             holder.tv_title.setText(titles.get(i));
             final String msg = titles.get(i);
             holder.tv_title.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     editText.setText(msg);
                     if(popupWindow!=null&&popupWindow.isShowing()){
                         popupWindow.dismiss();
                         popupWindow = null;
                     }
                 }
             });

             holder.delete.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     titles.remove(titles.get(i));
                     notifyDataSetChanged();
                 }
             });

         }


         @Override
         public int getItemCount() {
             return titles.size();
         }

         class MyViewHolder extends RecyclerView.ViewHolder {
          private TextView tv_title;
          private ImageView delete;
          public MyViewHolder(@NonNull View itemView) {
              super(itemView);
              tv_title = itemView.findViewById(R.id.tv_title);
              delete  =  itemView.findViewById(R.id.iv_delete);
          }
      }
     }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(popupWindow!=null&&popupWindow.isShowing()){
            popupWindow.setFocusable(false);
            popupWindow.dismiss();
            popupWindow =null;
        }
        return super.onTouchEvent(event);
    }
}
