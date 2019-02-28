package com.example.oyj.myapplication.controller;
import com.example.oyj.myapplication.view.CalendarView;
import com.example.oyj.myapplication.activity.listener.CalendarControllerListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class CalendarController implements OnClickListener{
    private final String TAG = "Calendar controller";

    private CalendarView calendarView;
    private CalendarControllerListener listener;

    public CalendarController(CalendarView calendarView, CalendarControllerListener listener) {
        this.calendarView = calendarView;
        this.listener = listener;
    }
/**
 * 当点击日期（day-ImageButton）
 */
public void onClick(View v) {
    Log.i(TAG, "onClick");

    listener.onClickDaySuccess(v);
}

}
