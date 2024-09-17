package com.hengchang.testoptimize.testBlockCanary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hengchang.testoptimize.R;

public class TestBlockActivity extends AppCompatActivity {

    public static String TAG = "TestBlockActivity.j";
    private LinearLayout lyBlockContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_block);
        lyBlockContent = findViewById(R.id.ly_block_content);
    }
    
    public void btBlock1(View view){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void btBlock2(View view){
        int i = 0;
        while (i<100000){
            Log.i(TAG, "btBlock2: "+i);
            i++;
        }
    }

    public void btBlock3(View view){
        addView(lyBlockContent,39);
        int childDeepCount = getChildDeepCount((ViewGroup) lyBlockContent.getChildAt(0));
        Log.i(TAG, "btBlock3: "+childDeepCount);

    }

    public int getChildDeepCount(ViewGroup viewGroup){

        int index = 0;
        while (viewGroup.getChildCount() >0){
            viewGroup = (ViewGroup) viewGroup.getChildAt(0);
            index ++;
        }

        return index;
    }
    
    
    public void addView(ViewGroup root,int index){
        View layoutView = LayoutInflater.from(this).inflate(R.layout.block_layout_item,root,false);
        if(index >0){
            LinearLayout linearLayout = layoutView.findViewById(R.id.deepest);
            addView(linearLayout ,index-1);  
        }
        root.addView(layoutView);
    }
}