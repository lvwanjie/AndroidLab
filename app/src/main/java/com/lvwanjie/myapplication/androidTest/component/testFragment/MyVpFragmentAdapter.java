package com.lvwanjie.myapplication.androidTest.component.testFragment;

import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyVpFragmentAdapter extends FragmentPagerAdapter {

    public MyVpFragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {


        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

}
