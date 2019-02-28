package com.example.oyj.myapplication.controller;
import com.example.oyj.myapplication.view.RewardView;
import com.example.oyj.myapplication.activity.listener.RewardControllerListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
public class RewardController implements OnClickListener{
    private final String TAG = " controller";
    private RewardView rewardView;
    private RewardControllerListener listener;
    public RewardController(RewardView view, RewardControllerListener listener) {
        this.rewardView = view;
        this.listener = listener;
    }

    /**
     * 当点击奖励页面
     */
    public void onClick(View v) {
        Log.i(TAG, "onClick");
        listener.onClickRewardSuccess();//引用

    }

}
