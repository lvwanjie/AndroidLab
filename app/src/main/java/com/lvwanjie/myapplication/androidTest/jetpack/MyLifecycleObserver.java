package com.lvwanjie.myapplication.androidTest.jetpack;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

class MyLifecycleObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){

    }

    public static  class MyLifecycleEvent implements LifecycleEventObserver{

        @Override
        public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
            switch (event.getTargetState()){
                case DESTROYED:
                    break;


            }
        }
    }

    public static class MyDefaultLifecycleObserver implements DefaultLifecycleObserver{
        @Override
        public void onCreate(@NonNull LifecycleOwner owner) {
            DefaultLifecycleObserver.super.onCreate(owner);
        }
    }
}
