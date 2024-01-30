package com.lvwanjie.myapplication.kotlinTest.testFx;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.common.reflect.TypeParameter;

public class TestFx<VH extends ViewModel> extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        new ViewModelProvider(this).get(TypeParameter<VH>);
    }
}
