package com.lvwanjie.myapplication.androidTest.widget.testDialog;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lvwanjie.myapplication.R;


public class BindPhoneDialog extends BottomSheetDialog implements View.OnClickListener {

    private EditText edPhoneNum;
    private EditText edSmsCode ;
    private EditText edImgCode ;
    private ImageFilterView imgCode;
    private Button btSave;

    public BindPhoneDialog(@NonNull Context activity) {
        super(activity);
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_bind_phone_layout,null);
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        setContentView(view,layoutParams);
        FrameLayout bottom = findViewById(R.id.design_bottom_sheet);
        if (bottom != null) {
            bottom.setBackgroundResource(android.R.color.transparent);
        }
        getBehavior().setHideable(false);


        initView(view);
    }


    private void initView(View view){
        edPhoneNum =  view.findViewById(R.id.ed_phone_num);
        edSmsCode = view.findViewById(R.id.ed_sms_code);
//        tvSendSmsCode = view.findViewById(R.id.tv_send_sms);
        edImgCode = view.findViewById(R.id.ed_img_code);
        imgCode = view.findViewById(R.id.ifv_img_code);
        btSave = view.findViewById(R.id.bt_save);
        edPhoneNum.addTextChangedListener(new MyTextWatch());
        edSmsCode.addTextChangedListener(new MyTextWatch());
        edImgCode.addTextChangedListener(new MyTextWatch());
//        tvSendSmsCode.setOnClickListener(this);
        btSave.setOnClickListener(this);
        imgCode.setOnClickListener(this);
    }

    private void checkBtSaveEnable(){
        String phoneNum = edPhoneNum.getText().toString();
        String smsCode = edSmsCode.getText().toString();
        String imgCode = edImgCode.getText().toString();
        if(!TextUtils.isEmpty(phoneNum) &&
                !TextUtils.isEmpty(smsCode) &&
                !TextUtils.isEmpty(imgCode)){
            btSave.setEnabled(true);
        }else {
            btSave.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.tv_get_sms:
//                activity.getPresenter().getSmsCode(new MyBindPhonePresenter.SmsCodeCallBack() {
//                    @Override
//                    public void onSuccess() {
//                        tvSendSmsCode.startCountDown();
//                    }
//                });
//                break;
//            case R.id.bt_save:
//                activity.getPresenter().bindPhoneNum();
//                break;
//            case R.id.ifv_img_code:
//                activity.getPresenter().getImageCode(new MyBindPhonePresenter.ImageCodeCallBack() {
//                    @Override
//                    public void onImage(ImgCodeEntity entity) {
//                        imgCode.setImageBitmap(BitmapUtils.base64ToBitmap(entity.imageBase64));
//                    }
//                });
//                break;
        }
    }


    private class MyTextWatch implements TextWatcher {

        private View watchView;

//        public MyTextWatch(View view){
//            this.watchView = view;
//        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            checkBtSaveEnable();
        }
    }
}
