package com.lvwanjie.myapplication.androidTest.widget.testXD;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

//import com.dangdang.buy2.widget.EasyTextView;
//import com.dangdang.discovery.R;
import com.google.android.material.appbar.AppBarLayout;
import com.lvwanjie.myapplication.R;

//import net.lucode.hackware.magicindicator.MagicIndicator;

public class TransBehavior extends CoordinatorLayout.Behavior{

    //appbar 最大滚动距离
    private int appBarMaxScrollHeight = -1;
    private View  titleViewBg;
//    private TextView tvTitle;
//    private TextView etvShare,etvBack;
    // 如果获取最大滚动距离相关的view发生改变 ，可以设置此为true 就可以重新获取高度了
    private boolean isReset;
    private LinearLayout tabIndicator;
    private ImageView ivHeadBg;

    public TransBehavior(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    public void resetHeightFlag(){
        isReset = true;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {

        if(appBarMaxScrollHeight < 0 || isReset){
            isReset = false;
            RelativeLayout bgTitleLayout = dependency.findViewById(R.id.rl_bg_title_layout);
            View indicator = dependency.findViewById(R.id.tab_indicator);
            int bgHeight = bgTitleLayout.getHeight();
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) indicator.getLayoutParams();
            appBarMaxScrollHeight = bgHeight + layoutParams.topMargin - child.getHeight();
        }

        if(appBarMaxScrollHeight >0){
            int dependencyTop = dependency.getTop();
           float alpha = Math.abs((float)dependencyTop/(float) appBarMaxScrollHeight);
            if (titleViewBg == null) {
                titleViewBg = child.findViewById(R.id.view_bg);
            }

            if(tabIndicator == null){
                tabIndicator = dependency.findViewById(R.id.tab_indicator);
            }
            titleViewBg.setAlpha(alpha);

            if(alpha == 1){
                tabIndicator.setBackgroundColor(Color.parseColor("#78c5f2"));

            }else {
                tabIndicator.setBackgroundResource(R.drawable.bg_book_topic_indicator);
            }

            if(ivHeadBg == null){
                ivHeadBg = parent.findViewById(R.id.iv_head_bg);
            }

            if(dependencyTop <= appBarMaxScrollHeight){
                ivHeadBg.setTop(dependencyTop);
            }
        }

        return true;
    }
}
