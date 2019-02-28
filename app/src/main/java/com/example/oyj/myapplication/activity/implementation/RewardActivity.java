package com.example.oyj.myapplication.activity.implementation;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.oyj.myapplication.model.star;
import com.example.oyj.myapplication.R;
import com.example.oyj.myapplication.activity.listener.RewardControllerListener;
import com.example.oyj.myapplication.model.AppData;
import com.example.oyj.myapplication.controller.RewardController;
import com.example.oyj.myapplication.view.RewardView;
import java.util.Calendar;

public class RewardActivity extends Activity implements RewardControllerListener {
    public int stars = 0;
    @Override//c初始化奖励界面
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppData application = (AppData) this.getApplication();
        String Theme = application.getTHeme();//主题
        if (Theme.equals("") || Theme.equals("boy")) setContentView(R.layout.reward_boy);
        else if (Theme.equals("girl")) setContentView(R.layout.reward_girl);
        //activity连接 到view 和controller
        RewardController rewardcontroller = new RewardController((RewardView) this.findViewById(R.id.page), this);
        //日历控制器将截获日历表的事件
        ((RewardView) this.findViewById(R.id.page)).setRewardListeners(rewardcontroller);
        Calendar calendar = Calendar.getInstance();
        ImageButton imgb = findViewById(R.id.reward_middle);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        int day=judgeday(application.getButton_id());//根据之前点击到的按钮，返回对应天数的整数
        int theDay =application.getUser().day;//拿到User信息里面保存的天数的整数
        boolean isTheDay =(day==theDay);//比较，你点击的日子和文件保存的日子
        star s=application.getUser().stars[day-1];//得到你文件保存的日子的星星数目
        int time =0;
        if (3 <= hour && 10 >= hour) {//早上得分3
            time =1;
            imgb.setImageResource(R.mipmap.morning);//设置图片为早上
        } else if (10 <= hour && hour <= 15) {
           time =2;
            imgb.setImageResource(R.mipmap.daytime);
        } else if (16 <= hour && hour <= 24) {
           time=3;
            imgb.setImageResource(R.mipmap.night);
        }
        if(!isTheDay) stars=0;//不是同一天，对不起，给你个鸡蛋
        else if(s.touch_number>=3) stars=0;//这天点击了3次以上，也给你个鸡蛋
        else if (time==1) {//早上得分3
            stars = 3;
            if(s.reward_morning!=0) stars=0;//早上点击过了，只能给你鸡蛋
            else if(isTheDay)//早上没有击过，是同一天
            {s.reward_morning=1;++s.touch_number;}//好了，这样你早上就点击了，而且点击数加一
            imgb.setImageResource(R.mipmap.morning);//设置图片为早上
        } else if (time==2) {
            stars = 2;
            if(s.reward_noon!=0) stars=0;
            else if(isTheDay)
            {s.reward_noon=1;++s.touch_number;}
            imgb.setImageResource(R.mipmap.daytime);
        } else if (time==3) {
            stars = 4;
            if(s.reward_night!=0) stars=0;
            else if(isTheDay)
            {s.reward_night=1;++s.touch_number;}
            imgb.setImageResource(R.mipmap.night);
        }
        TextView v = findViewById(R.id.textView5);
        v.setText(stars + "");
        application.saveUser();
    }
    //退出奖励界面
    public void onClickRewardSuccess() {
        Intent mIntent = new Intent();//没有任何参数（意图），只是用来传递数据
        mIntent.putExtra("Stars_", String.valueOf(stars));
        setResult(RESULT_OK, mIntent);
        RewardActivity.this.finish();
    }
    //天数选择
    public int judgeday(int id) {
        switch (id) {
            case R.id.day1: return 1;
            case R.id.day2: return 2;
            case R.id.day3: return 3;
            case R.id.day4: return 4;
            case R.id.day5: return 5;
            case R.id.day6: return 6;
            case R.id.day7: return 7;
            case R.id.day8: return 8;
            case R.id.day9: return 9;
            case R.id.day10:return 10;
            case R.id.day11: return 11;
            case R.id.day12: return 12;
            case R.id.day13: return 13;
            case R.id.day14: return 14;
            case R.id.day15: return 15;
            case R.id.day16: return 16;
            case R.id.day17: return 17;
            case R.id.day18: return 18;
            case R.id.day19: return 19;
            case R.id.day20: return 20;
            case R.id.day21: return 21;
        }
        return 0;
    }
}
