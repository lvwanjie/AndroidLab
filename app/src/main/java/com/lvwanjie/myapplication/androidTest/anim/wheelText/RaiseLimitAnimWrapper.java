package com.lvwanjie.myapplication.androidTest.anim.wheelText;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.androidTest.utils.DisplayUtils;


public class RaiseLimitAnimWrapper {

    private View rootView;
    private TextView tvTips2;
    private TextView tvRaiseQuota;
    private TextView tvRaiseTip;
    private ImageView ivCoinGif;
    private ConstraintLayout clQuotaAnimLayout;

    public RaiseLimitAnimWrapper(View rootView){
        this.rootView = rootView;
//        tvTips2 = rootView.findViewById(R.id.tv_tip2);
//        tvRaiseQuota = rootView.findViewById(R.id.tv_raise_quota);
//        tvRaiseTip = rootView.findViewById(R.id.tv_raise_tip);
//        ivCoinGif = rootView.findViewById(R.id.iv_coin_gif);
//        clQuotaAnimLayout = rootView.findViewById(R.id.cl_quota_anim_layout);
    }

    AnimatorSet animatorSet = new AnimatorSet();

    public void startAnim(){
        clQuotaAnimLayout.setVisibility(View.VISIBLE);
        animatorSet.playSequentially(
                transGoldCoinAnim(),
                    raiseQuotaAnimIn(),
                        quotaChangeAnim(1000,30000),
                        raiseQuotaAnimOut(),
                        raiseTipIn(),
                        raiseTipOut()
                );
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("startAnim", "onAnimationEnd: ");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.start();
    }

    private ValueAnimator transGoldCoinAnim(){

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,1);
        int translateY = DisplayUtils.dpToPx(40);
        ivCoinGif.setTranslationY(translateY);
        ivCoinGif.setAlpha(1.0f);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fValue = (float) animation.getAnimatedValue();
                ivCoinGif.setTranslationY(translateY -fValue * translateY);
                ivCoinGif.setScaleX(fValue);
                ivCoinGif.setScaleY(fValue);
            }
        });
        Glide.with(ivCoinGif.getContext()).asGif().listener(new RequestListener<GifDrawable>(){

            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                resource.setLoopCount(1);
                return false;
            }
        }).load(R.mipmap.gold).into(ivCoinGif);
        return valueAnimator;

    }

    private ValueAnimator raiseQuotaAnimIn(){
        int translateY = DisplayUtils.dpToPx(40);
        tvRaiseQuota.setTranslationY(translateY);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,1);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fValue = (float) animation.getAnimatedValue();
                tvRaiseQuota.setTranslationY(translateY -fValue * translateY);
                tvRaiseQuota.setAlpha(fValue);
            }
        });
        return valueAnimator;
    }

    private ValueAnimator quotaChangeAnim(int oldValue,int value){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(oldValue,value);
        valueAnimator.setDuration(1000);
        valueAnimator.setStartDelay(100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) valueAnimator.getAnimatedValue();
                tvTips2.setText(value+"");
            }
        });
        return valueAnimator;
    }

    private ValueAnimator raiseQuotaAnimOut(){
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1,0);
        valueAnimator.setDuration(500);
        valueAnimator.setStartDelay(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fValue = (float) animation.getAnimatedValue();
                tvRaiseQuota.setAlpha(fValue);
                ivCoinGif.setAlpha(fValue);
            }
        });
        return valueAnimator;
    }

    private  ValueAnimator raiseTipIn(){
        int translateY = DisplayUtils.dpToPx(20);
        tvRaiseTip.setTranslationY(translateY);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,1);
        valueAnimator.setDuration(800);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fValue = (float) animation.getAnimatedValue();
                tvRaiseTip.setTranslationY(translateY-fValue*translateY);
                tvRaiseTip.setAlpha(fValue);
            }
        });
        return valueAnimator;
    }

    private  ValueAnimator raiseTipOut(){
        int translateY = -DisplayUtils.dpToPx(20);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1,0);
        valueAnimator.setStartDelay(500);
        valueAnimator.setDuration(800);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fValue = (float) animation.getAnimatedValue();
                tvRaiseTip.setTranslationY((1-fValue)*translateY);
                tvRaiseTip.setAlpha(fValue);
            }
        });
        return valueAnimator;
    }

}
