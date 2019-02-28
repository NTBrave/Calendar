package com.example.oyj.myapplication.view;

import com.example.oyj.myapplication.R;
import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;

public class CalendarView extends LinearLayout{

    public CalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //设置日历监听器
    public void setListeners(OnClickListener onClickListener){
        findViewById(R.id.day1).setOnClickListener(onClickListener);
        findViewById(R.id.day2).setOnClickListener(onClickListener);
        findViewById(R.id.day3).setOnClickListener(onClickListener);
        findViewById(R.id.day4).setOnClickListener(onClickListener);
        findViewById(R.id.day5).setOnClickListener(onClickListener);
        findViewById(R.id.day6).setOnClickListener(onClickListener);
        findViewById(R.id.day7).setOnClickListener(onClickListener);
        findViewById(R.id.day8).setOnClickListener(onClickListener);
        findViewById(R.id.day8).setOnClickListener(onClickListener);
        findViewById(R.id.day9).setOnClickListener(onClickListener);
        findViewById(R.id.day10).setOnClickListener(onClickListener);
        findViewById(R.id.day11).setOnClickListener(onClickListener);
        findViewById(R.id.day12).setOnClickListener(onClickListener);
        findViewById(R.id.day13).setOnClickListener(onClickListener);
        findViewById(R.id.day14).setOnClickListener(onClickListener);
        findViewById(R.id.day15).setOnClickListener(onClickListener);
        findViewById(R.id.day16).setOnClickListener(onClickListener);
        findViewById(R.id.day17).setOnClickListener(onClickListener);
        findViewById(R.id.day18).setOnClickListener(onClickListener);
        findViewById(R.id.day19).setOnClickListener(onClickListener);
        findViewById(R.id.day20).setOnClickListener(onClickListener);
        findViewById(R.id.day21).setOnClickListener(onClickListener);
    }







   // public String getStars() {return ((EditText) this.findViewById(R.id.day1)).getText().toString();}

   // public void setStarsError(String error) {((EditText) this.findViewById(R.id.stars_2)).setError(error);}
}


