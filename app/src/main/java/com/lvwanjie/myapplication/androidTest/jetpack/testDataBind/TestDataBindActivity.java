package com.lvwanjie.myapplication.androidTest.jetpack.testDataBind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.lvwanjie.myapplication.MyApplication;
import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.databinding.ActivityTestDataBindBinding;

public class TestDataBindActivity extends AppCompatActivity {

    private ActivityTestDataBindBinding dataBindBinding;

    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AndroidViewModel(MyApplication.mInstance);

        dataBindBinding = DataBindingUtil.setContentView(this,R.layout.activity_test_data_bind);
        dataBindBinding.myText.setText("");
        myViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        dataBindBinding.setMyVm(myViewModel);
        myViewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });

        getLifecycle().addObserver(new MyCompont());

    }
}