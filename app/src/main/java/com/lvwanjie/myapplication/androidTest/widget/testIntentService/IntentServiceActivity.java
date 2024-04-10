package com.lvwanjie.myapplication.androidTest.widget.testIntentService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lvwanjie.myapplication.R;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
    }

    public void btClick(View View){
        MyIntentService.startActionBaz(this,"p1","p2");
        startActivity(new Intent());
    }


}