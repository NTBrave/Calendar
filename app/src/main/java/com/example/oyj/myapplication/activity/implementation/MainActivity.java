package com.example.oyj.myapplication.activity.implementation;

import com.example.oyj.myapplication.model.User;
import com.example.oyj.myapplication.R;
import com.example.oyj.myapplication.activity.listener.CalendarControllerListener;
import com.example.oyj.myapplication.activity.listener.GiftControllerListener;
import com.example.oyj.myapplication.activity.listener.HomeControllerListener;
import com.example.oyj.myapplication.controller.GiftController;
import com.example.oyj.myapplication.model.AppData;
import com.example.oyj.myapplication.view.GiftView;
import com.example.oyj.myapplication.view.CalendarView;
import com.example.oyj.myapplication.view.HomeView;
import com.example.oyj.myapplication.controller.CalendarController;
import com.example.oyj.myapplication.controller.HomeController;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends Activity
        implements CalendarControllerListener,HomeControllerListener,GiftControllerListener {
    public String NewStars = null;
    public ImageButton img = null;
    public User user = null;
    //初始化主界面
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

// 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final AppData application = (AppData) this.getApplication();//获取数据
        String Theme = application.getTHeme();//获得主题
        String stars = application.getSTARS();//获得星星数目
        String grade = application.getGrade();//获得等级
        if(Theme=="") Theme="boy";
        if(stars=="") stars="0";
        if(grade =="") grade="0";
        user = application.getUser();//获得用户
        application.setMain(this);
//        application.setUser(user);
        //判断主题，选择对应主题的xml文件
        if (Theme.equals("") || Theme.equals("boy")) setContentView(R.layout.activity_main_boy);
        else if (Theme.equals("girl")) setContentView(R.layout.activity_main_girl);

        //测试人员按钮设置
        ImageButton btn = findViewById(R.id.imageButton6);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                application.getUser().addday();
            }
        });

        //初始化每一天的奖励图片，有的是没有图片的
        judge_starsImage(user.stars[0].stars
                , (ImageButton) findViewById(R.id.day1
                ));
        judge_starsImage(user.stars[1].stars, (ImageButton) findViewById(R.id.day2));
        judge_starsImage(user.stars[2].stars, (ImageButton) findViewById(R.id.day3));
        judge_starsImage(user.stars[3].stars, (ImageButton) findViewById(R.id.day4));
        judge_starsImage(user.stars[4].stars, (ImageButton) findViewById(R.id.day5));
        judge_starsImage(user.stars[5].stars, (ImageButton) findViewById(R.id.day6));
        judge_starsImage(user.stars[6].stars, (ImageButton) findViewById(R.id.day7));
        judge_starsImage(user.stars[7].stars, (ImageButton) findViewById(R.id.day8));
        judge_starsImage(user.stars[8].stars, (ImageButton) findViewById(R.id.day9));
        judge_starsImage(user.stars[9].stars, (ImageButton) findViewById(R.id.day10));
        judge_starsImage(user.stars[10].stars, (ImageButton) findViewById(R.id.day11));
        judge_starsImage(user.stars[11].stars, (ImageButton) findViewById(R.id.day12));
        judge_starsImage(user.stars[12].stars, (ImageButton) findViewById(R.id.day13));
        judge_starsImage(user.stars[13].stars, (ImageButton) findViewById(R.id.day14));
        judge_starsImage(user.stars[14].stars, (ImageButton) findViewById(R.id.day15));
        judge_starsImage(user.stars[15].stars, (ImageButton) findViewById(R.id.day16));
        judge_starsImage(user.stars[16].stars, (ImageButton) findViewById(R.id.day17));
        judge_starsImage(user.stars[17].stars, (ImageButton) findViewById(R.id.day18));
        judge_starsImage(user.stars[18].stars, (ImageButton) findViewById(R.id.day19));
        judge_starsImage(user.stars[19].stars, (ImageButton) findViewById(R.id.day20));
        judge_starsImage(user.stars[20].stars, (ImageButton) findViewById(R.id.day21));

        //设置监听与控制器
        CalendarController calendarcontroller = new CalendarController((CalendarView) this.findViewById(R.id.day), this);
        ((CalendarView) this.findViewById(R.id.day)).setListeners(calendarcontroller);
        HomeController homecontroller = new HomeController((HomeView) this.findViewById(R.id.Home), this);
        ((HomeView) this.findViewById(R.id.Home)).setThemeListeners(homecontroller);//主题按钮
        GiftController giftcontroller=new GiftController((GiftView) this.findViewById(R.id.gift_view),this);
        ((GiftView) this.findViewById(R.id.gift_view)).setGiftListeners(giftcontroller);
        //显示
        final TextView star = (TextView) findViewById(R.id.Stars_numbers);
        final TextView grades = (TextView) findViewById(R.id.grade);
        star.setText(stars);//显示星星数目
        grades.setText(grade);//显示等级
    }

    @Override//下面函数在奖励界面结束后运行，刷新日历界面的数据
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //获得奖励界面返回来的新增加的星星数目
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    NewStars = data.getStringExtra("Stars_");
                    Log.e("1", "run:---------> " + NewStars);
                }
                break;

        }

        AppData application = (AppData) this.getApplication();
        final TextView star = (TextView) findViewById(R.id.Stars_numbers);
        final TextView grades = (TextView) findViewById(R.id.grade);
        String stars = String.valueOf(Integer.valueOf(application.getSTARS()) + Integer.valueOf(NewStars));//计算星星总数
        star.setText(stars);//展示新的星星总数
        application.setSTARS(stars);//保存新的星星总数
        String grade = application.getGrade();//获得等级
        grades.setText(grade);//展示等级

        user = application.getUser();//获得用户信息，下面是选择点击到的天数图片，设置对应的星星图片，保存每一天的星星数目
        if (img.getId() == R.id.day1) {
            judge_starsImage(user.stars[0].stars + Integer.valueOf(NewStars), img);
            user.stars[0].setStars(user.stars[0].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day2) {
            judge_starsImage(user.stars[1].stars
                    + Integer.valueOf(NewStars), img);
            user.stars[1].setStars(user.stars[1].stars +
                    Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day3) {
            judge_starsImage(user.stars[2].stars + Integer.valueOf(NewStars), img);
            user.stars[2].setStars(user.stars[2].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day4) {
            judge_starsImage(user.stars[3].stars + Integer.valueOf(NewStars), img);
            user.stars[3].setStars(user.stars[3].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day5) {
            judge_starsImage(user.stars[4].stars + Integer.valueOf(NewStars), img);
            user.stars[4].setStars(user.stars[4].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day6) {
            judge_starsImage(user.stars[5].stars + Integer.valueOf(NewStars), img);
            user.stars[5].setStars(user.stars[5].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day7) {
            judge_starsImage(user.stars[6].stars + Integer.valueOf(NewStars), img);
            user.stars[6].setStars(user.stars[6].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day8) {
            judge_starsImage(user.stars[7].stars + Integer.valueOf(NewStars), img);
            user.stars[7].setStars(user.stars[7].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day9) {
            judge_starsImage(user.stars[8].stars + Integer.valueOf(NewStars), img);
            user.stars[8].setStars(user.stars[8].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day10) {
            judge_starsImage(user.stars[9].stars + Integer.valueOf(NewStars), img);
            user.stars[9].setStars(user.stars[9].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day11) {
            judge_starsImage(user.stars[10].stars + Integer.valueOf(NewStars), img);
            user.stars[10].setStars(user.stars[10].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day12) {
            judge_starsImage(user.stars[11].stars + Integer.valueOf(NewStars), img);
            user.stars[11].setStars(user.stars[11].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day13) {
            judge_starsImage(user.stars[12].stars + Integer.valueOf(NewStars), img);
            user.stars[12].setStars(user.stars[12].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day14) {
            judge_starsImage(user.stars[13].stars + Integer.valueOf(NewStars), img);
            user.stars[13].setStars(user.stars[13].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day15) {
            judge_starsImage(user.stars[14].stars + Integer.valueOf(NewStars), img);
            user.stars[14].setStars(user.stars[14].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day16) {
            judge_starsImage(user.stars[15].stars + Integer.valueOf(NewStars), img);
            user.stars[15].setStars(user.stars[15].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day17) {
            judge_starsImage(user.stars[16].stars + Integer.valueOf(NewStars), img);
            user.stars[16].setStars(user.stars[16].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day18) {
            judge_starsImage(user.stars[17].stars + Integer.valueOf(NewStars), img);
            user.stars[17].setStars(user.stars[17].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day19) {
            judge_starsImage(user.stars[18].stars + Integer.valueOf(NewStars), img);
            user.stars[18].setStars(user.stars[18].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day20) {
            judge_starsImage(user.stars[19].stars + Integer.valueOf(NewStars), img);
            user.stars[19].setStars(user.stars[19].stars + Integer.valueOf(NewStars));
        }
        if (img.getId() == R.id.day21) {
            judge_starsImage(user.stars[20].stars + Integer.valueOf(NewStars), img);
            user.stars[20].setStars(user.stars[20].stars + Integer.valueOf(NewStars));
        }

        application.setUser(user);//保存用户信息
        application.saveUser();//保存用户信息
    }

    @Override//函数在点击日期成功后运行
    public void onClickDaySuccess(View v) {

        int id = v.getId();//获得你所点击的按钮id
        img = (ImageButton) findViewById(id);
        AppData application = (AppData) this.getApplication();
        application.setButton_id(id);//设置按钮id到全局变量，这是给奖励界面用到的数据
        Intent intent2 = new Intent(this, RewardActivity.class);//启动新的奖励界面
        startActivityForResult(intent2, 1);//请求参数设为1//数据请求
        //((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.android_btn_pressed));
    }

    @Override//点击进入用户信息界面
    public void onClickHomeSuccess() {
            Intent intent11 = new Intent(this, HomeActivity.class);
        startActivity(intent11);//请求参数设为2//数据请求
    }

    @Override//点击进入礼物界面
    public void onClickGiftSuccess() {
        Intent intent = new Intent(this, GiftActivity.class);
        ((Activity) this).overridePendingTransition(0, 0);
        startActivity(intent);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        MainActivity.this.finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    //星星个数图片选择函数
    public void judge_starsImage(int sss,ImageButton i) {
        switch (sss) {
            case 2: i.setImageResource(R.mipmap.s2);break;
            case 3: i.setImageResource(R.mipmap.s3);break;
            case 4: i.setImageResource(R.mipmap.s4);break;
            case 5: i.setImageResource(R.mipmap.s5);break;
            case 6: i.setImageResource(R.mipmap.s6);break;
            case 7: i.setImageResource(R.mipmap.s7);break;
            case 9: i.setImageResource(R.mipmap.s9);break;
            case 0: break;
            default:i.setImageResource(R.mipmap.s1);break;
        }
    }
    //更新Mainactivity主界面，在用户信息界面点击换主题成功之后运行
    public void update(){
        AppData application = (AppData) this.getApplication();
        String Theme = application.getTHeme();//获得主题
        if (Theme.equals("") || Theme.equals("boy")) setContentView(R.layout.activity_main_boy);
        else if (Theme.equals("girl")) setContentView(R.layout.activity_main_girl);
        user=application.getUser();
        judge_starsImage(user.stars[0].stars, (ImageButton) findViewById(R.id.day1));
        judge_starsImage(user.stars[1].stars, (ImageButton) findViewById(R.id.day2));
        judge_starsImage(user.stars[2].stars, (ImageButton) findViewById(R.id.day3));
        judge_starsImage(user.stars[3].stars, (ImageButton) findViewById(R.id.day4));
        judge_starsImage(user.stars[4].stars, (ImageButton) findViewById(R.id.day5));
        judge_starsImage(user.stars[5].stars, (ImageButton) findViewById(R.id.day6));
        judge_starsImage(user.stars[6].stars, (ImageButton) findViewById(R.id.day7));
        judge_starsImage(user.stars[7].stars, (ImageButton) findViewById(R.id.day8));
        judge_starsImage(user.stars[8].stars, (ImageButton) findViewById(R.id.day9));
        judge_starsImage(user.stars[9].stars, (ImageButton) findViewById(R.id.day10));
        judge_starsImage(user.stars[10].stars, (ImageButton) findViewById(R.id.day11));
        judge_starsImage(user.stars[11].stars, (ImageButton) findViewById(R.id.day12));
        judge_starsImage(user.stars[12].stars, (ImageButton) findViewById(R.id.day13));
        judge_starsImage(user.stars[13].stars, (ImageButton) findViewById(R.id.day14));
        judge_starsImage(user.stars[14].stars, (ImageButton) findViewById(R.id.day15));
        judge_starsImage(user.stars[15].stars, (ImageButton) findViewById(R.id.day16));
        judge_starsImage(user.stars[16].stars, (ImageButton) findViewById(R.id.day17));
        judge_starsImage(user.stars[17].stars, (ImageButton) findViewById(R.id.day18));
        judge_starsImage(user.stars[18].stars, (ImageButton) findViewById(R.id.day19));
        judge_starsImage(user.stars[19].stars, (ImageButton) findViewById(R.id.day20));
        judge_starsImage(user.stars[20].stars, (ImageButton) findViewById(R.id.day21));
        CalendarController calendarcontroller = new CalendarController((CalendarView) this.findViewById(R.id.day), this);
        ((CalendarView) this.findViewById(R.id.day)).setListeners(calendarcontroller);

        HomeController homecontroller = new HomeController((HomeView) this.findViewById(R.id.Home), this);
        ((HomeView) this.findViewById(R.id.Home)).setThemeListeners(homecontroller);//主题按钮

        GiftController giftcontroller=new GiftController((GiftView) this.findViewById(R.id.gift_view),this);
        ((GiftView) this.findViewById(R.id.gift_view)).setGiftListeners(giftcontroller);
        final TextView star = (TextView) findViewById(R.id.Stars_numbers);
        final TextView grades = (TextView) findViewById(R.id.grade);
        String stars = application.getSTARS();
        String grade = application.getGrade();//获得等级
        star.setText(stars);
        grades.setText(grade);
        }


}




