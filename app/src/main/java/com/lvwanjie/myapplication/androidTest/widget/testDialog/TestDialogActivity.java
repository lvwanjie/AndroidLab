package com.lvwanjie.myapplication.androidTest.widget.testDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.androidTest.utils.DisplayUtils;
import com.lvwanjie.myapplication.javaTest.testPattern.FormatCheckUtils;

public class TestDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);


    }

    private void showAuthConfirmDialog(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_auth_confirm_layout,null);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubtitle = view.findViewById(R.id.tv_subtitle);
        TextView tvContent =  view.findViewById(R.id.tv_content);
        TextView tvSubmit = view.findViewById(R.id.tv_submit);
        tvContent.setText("");
        tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        WindowManager.LayoutParams layoutParams = bottomSheetDialog.getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        bottomSheetDialog.setContentView(view,layoutParams);
        bottomSheetDialog.getBehavior().setHideable(false);
        bottomSheetDialog.show();
    }

    private void showCompatDialog(){

        AppCompatDialog bottomSheetDialog = new AppCompatDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_auth_confirm_layout,null);
        WindowManager.LayoutParams layoutParams = bottomSheetDialog.getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = DisplayUtils.dpToPx(500);
        bottomSheetDialog.setContentView(view,layoutParams);
        bottomSheetDialog.show();
    }

    public void btClick(View view){
        showAuthConfirmDialog();
    }

    public void compatDialogShow(View view){
        showCompatDialog();
    }


}