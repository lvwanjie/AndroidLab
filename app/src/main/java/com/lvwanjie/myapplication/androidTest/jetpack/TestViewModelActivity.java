package com.lvwanjie.myapplication.androidTest.jetpack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.lvwanjie.myapplication.R;

public class TestViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_model);

        MyViewModel myViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return null;
            }
        }).get(MyViewModel.class);

        myViewModel.mLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });

        getLifecycle().addObserver(new MyLifecycleObserver());
    }
}