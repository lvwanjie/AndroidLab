package com.lvwanjie.myapplication.androidTest.widget.testVP2.viewpager;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.lvwanjie.myapplication.R;


public class MyAdapter extends PagerAdapter {

    private Integer[] mImgs = {R.drawable.img_06, R.drawable.img_01, R.drawable.img_02,
            R.drawable.img_03, R.drawable.img_04, R.drawable.img_05, R.drawable.img_06, R.drawable.img_01};
    private Context mContext;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mImgs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = null;
        imageView = new ImageView(mContext);

        imageView.setTag(position % mImgs.length);
        imageView.setImageResource(mImgs[position % mImgs.length]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击的位置是:::" + position, Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}


