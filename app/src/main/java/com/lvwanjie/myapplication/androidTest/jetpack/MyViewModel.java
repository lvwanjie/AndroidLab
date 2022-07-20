package com.lvwanjie.myapplication.androidTest.jetpack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

class MyViewModel extends ViewModel {


    public MutableLiveData<String> mLiveData = new MutableLiveData();
    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void getData(){
        mLiveData.setValue("");
    }
}
