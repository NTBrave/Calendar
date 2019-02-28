package com.example.oyj.myapplication.view;

import com.example.oyj.myapplication.R;
import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;

public class GiftView extends LinearLayout {

    public GiftView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //设置监听器
//    public void setGiftListeners(OnClickListener onClickListener){
//        findViewById(R.id.Return).setOnClickListener(onClickListener);
//    }
    public void setGiftListeners(OnClickListener onClickListener){
        findViewById(R.id.gift_Button).setOnClickListener(onClickListener);
    }
//    public void setGiftactivityListeners(OnClickListener onClickListener){
//        findViewById(R.id.).setOnClickListener(onClickListener);
//    }
}
