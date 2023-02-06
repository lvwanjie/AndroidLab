package com.lvwanjie.myapplication.androidTest.widget.testDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.javaTest.testPattern.FormatCheckUtils;

public class TestDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);
        Dialog dialog = new Dialog(this);

        EditText editText = null;
        editText.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if(source instanceof String){
                    return FormatCheckUtils.specialCharRemove(source.toString());
                }else{
                    return null;
                }
            }
        }});

        SpannableString ss = new SpannableString("source");
        ss.getSpans(1,2,Object.class);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


}