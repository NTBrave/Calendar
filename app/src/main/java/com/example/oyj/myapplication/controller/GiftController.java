package com.example.oyj.myapplication.controller;
import com.example.oyj.myapplication.view.GiftView;
import com.example.oyj.myapplication.activity.listener.GiftControllerListener;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
public class GiftController implements OnClickListener{
    private final String TAG = "Calendar controller";

    private GiftView view;
    private GiftControllerListener listener;

    public GiftController(GiftView view, GiftControllerListener listener) {
        this.view = view;
        this.listener = listener;
    }
    /**
     * 当点击日期（day-ImageButton）
     */
        public void onClick(View v) {
        Log.i(TAG, "onClick");

        listener.onClickGiftSuccess();
    }

}
