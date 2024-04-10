package com.lvwanjie.myapplication.androidTest.jetpack.testDataBind;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.lvwanjie.myapplication.BR;

public class Worker extends BaseObservable {

    private String mLastName;
    private String mFirstName;
    private boolean mIsFired=false;

    public Worker(String mLastName, String mFirstName) {
        this.mLastName = mLastName;
        this.mFirstName = mFirstName;
    }
    @Bindable
    public String getLastName() {
        return mLastName;
    }

    @Bindable
    public String getFirstName(){
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
        notifyPropertyChanged(BR.firstName);
    }
}
