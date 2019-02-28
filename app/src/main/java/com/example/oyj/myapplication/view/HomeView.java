package com.example.oyj.myapplication.view;

import com.example.oyj.myapplication.R;
import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;

public class HomeView extends LinearLayout {

    public HomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //设置主界监听器
    public void setThemeListeners(OnClickListener onClickListener){

        findViewById(R.id.Home_Theme).setOnClickListener(onClickListener);

    }


}
