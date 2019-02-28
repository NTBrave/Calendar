package com.example.oyj.myapplication.view;

import com.example.oyj.myapplication.R;
import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;

public class RewardView extends LinearLayout{
    public RewardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //设置奖励界面监听器
    public void setRewardListeners(OnClickListener onClickListener){
        findViewById(R.id.reward_middle).setOnClickListener(onClickListener);
        findViewById(R.id.reward_left).setOnClickListener(onClickListener);
        findViewById(R.id.reward_right).setOnClickListener(onClickListener);
    }

}
