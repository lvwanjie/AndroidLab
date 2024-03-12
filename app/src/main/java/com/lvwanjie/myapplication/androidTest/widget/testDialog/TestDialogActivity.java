package com.lvwanjie.myapplication.androidTest.widget.testDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
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
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
//import com.kongzue.dialogx.dialogs.CustomDialog;
//import com.kongzue.dialogx.interfaces.OnBindView;
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
//        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this,R.style.BottomSheetDialog);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this,R.style.BottomSheetStyle);
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

        FrameLayout bottom = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (bottom != null) {
            bottom.setBackgroundResource(android.R.color.transparent);
        }
        bottomSheetDialog.show();
//        View myView = view;
//        while (myView.getParent() != null && myView.getParent() instanceof View){
//            myView = (View) myView.getParent();
//            Log.i(TAG, "showAuthConfirmDialog: "+myView+"\n"+myView.getBackground());
//        }
//        bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
    }

    private static String TAG = "TestDialogActivity.j";

    private void showCompatDialog(){

        AppCompatDialog bottomSheetDialog = new AppCompatDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_auth_confirm_layout,null);
        WindowManager.LayoutParams layoutParams = bottomSheetDialog.getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = DisplayUtils.dpToPx(500);
        bottomSheetDialog.setContentView(view,layoutParams);
        bottomSheetDialog.show();

    }

    private void showNormalDialog(){
        Dialog dialog = new Dialog(this);
        View floatView = LayoutInflater.from(this).inflate(R.layout.dialog_auth_confirm_layout,null);
        dialog.setContentView(floatView);

        WindowManager.LayoutParams  layoutParams = dialog.getWindow().getAttributes();
        layoutParams.width = 1080;
        layoutParams.height = 1080;
        View mDecorView = dialog.getWindow().getDecorView();
        InsetDrawable colorDrawable = new InsetDrawable(new ColorDrawable(Color.parseColor("#7f78c5f2")),44);
        dialog.getWindow().setBackgroundDrawable(colorDrawable);
        dialog.getWindow().getDecorView().setPadding(0,0,0,0);

        dialog.show();
    }

    public void btClick(View view){
        showAuthConfirmDialog();
    }

    public void compatDialogShow(View view){
        showCompatDialog();
    }

    public void normalDialogShow(View view){
        showNormalDialog();
    }

    public void customDialogShow(View view){
//        CustomDialog.show(new OnBindView<CustomDialog>(R.layout.dialog_auth_confirm_layout) {
//            @Override
//            public void onBind(CustomDialog dialog, View v) {
//
//            }
//        });
    }

    public void bindDialog(View view){
        BindPhoneDialog bottomSheetDialog = new BindPhoneDialog(this);
        bottomSheetDialog.show();
    }




}