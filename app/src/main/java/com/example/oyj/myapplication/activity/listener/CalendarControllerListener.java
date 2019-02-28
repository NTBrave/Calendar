package com.example.oyj.myapplication.activity.listener;

import android.view.View;

/*MainActivity实现的方法，用于在以下两者之间建立通信
 *逻辑控制器和逻辑活动*/
public interface CalendarControllerListener {
    /*CalendarConreoller调用该方法，通知打卡活动成功*/
    public void onClickDaySuccess(View v);

}
