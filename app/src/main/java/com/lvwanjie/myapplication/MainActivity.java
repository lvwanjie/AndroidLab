package com.lvwanjie.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RecyclerView recyclerView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager linearLayoutManager;

        recyclerView.setAdapter(new MyAdapter());
//        requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAPTURE_AUDIO_OUTPUT},0);
    }

    public<T> void  a(Class<T> t){
        Intent intent = new Intent(this,t);
    }


   class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        public List<PageInfo> pageList = new ArrayList<>();


        public MyAdapter(){
            List<String> list = Arrays.asList(PageInfo.pages);
            int color = Color.WHITE;
            for(String str:list){
                PageInfo pageInfo = new PageInfo(str);
                pageInfo.itemColor = color;
                if(color == Color.WHITE){
                    color = Color.RED;
                }else {
                    color = Color.WHITE;
                }
                pageList.add(pageInfo);
            }

        }

       @NonNull
       @Override
       public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_page_item,parent,false);
           return new MyViewHolder(view);
       }

       @Override
       public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.bindData(pageList.get(position));
       }

       @Override
       public int getItemCount() {
           return pageList.size();
       }
   }

   class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;


       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           textView = itemView.findViewById(R.id.text);
       }

       public void bindData(PageInfo pageInfo){
           textView.setText(pageInfo.name);
           itemView.setBackgroundColor(pageInfo.itemColor);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(MainActivity.this,pageInfo.clz);
                   MainActivity.this.startActivity(intent);
               }
           });
       }
   }
}

