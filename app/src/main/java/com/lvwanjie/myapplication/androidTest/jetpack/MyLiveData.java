package com.lvwanjie.myapplication.androidTest.jetpack;

import androidx.lifecycle.LiveData;

class MyLiveData extends LiveData {

    @Override
    protected void postValue(Object value) {
        super.postValue(value);
    }

    @Override
    protected void setValue(Object value) {

    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
