package com.lvwanjie.myapplication.androidTest.widget.testEditText;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.lvwanjie.myapplication.R;

public class TestTextChangeActivity extends Activity {

    private EditText editText;
    private static String TAG = "TestTextChangeActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_text_change);
        editText = findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.i(TAG, "beforeTextChanged: ");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged: "+editText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
