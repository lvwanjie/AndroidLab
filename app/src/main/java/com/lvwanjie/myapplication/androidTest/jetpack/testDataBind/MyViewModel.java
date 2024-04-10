package com.lvwanjie.myapplication.androidTest.jetpack.testDataBind;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    public MutableLiveData<String> myLiveData = new MutableLiveData<>();

    public MutableLiveData<String>  getData(){
        myLiveData.postValue("");
        myLiveData.setValue("");
        return myLiveData;
    }

//    public MutableLiveData<String> getMyLiveData(){
//        return myLiveData;
//    }
}
