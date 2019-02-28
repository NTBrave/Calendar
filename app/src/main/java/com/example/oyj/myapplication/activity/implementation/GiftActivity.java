package com.example.oyj.myapplication.activity.implementation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.oyj.myapplication.model.AppData;
import com.example.oyj.myapplication.R;
import com.example.oyj.myapplication.activity.listener.GiftControllerListener;
import com.example.oyj.myapplication.controller.GiftController;
import com.example.oyj.myapplication.view.GiftView;

public class GiftActivity extends Activity implements GiftControllerListener {
        @Override//初始化礼物界面
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            AppData application = (AppData) this.getApplication();
            String Theme = application.getTHeme();//主题
            String stars = application.getSTARS();//获得星星数目
            String grade = application.getGrade();//获得等级
            if(Theme=="") Theme="boy";
            if(stars=="") stars="0";
            if(grade =="") grade="0";
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            if (Theme.equals("") || Theme.equals("boy")) setContentView(R.layout.gift_boy);
            else if (Theme.equals("girl")) setContentView(R.layout.gift_girl);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            final TextView star = (TextView) findViewById(R.id.Stars_numbers);
            final TextView grades = (TextView) findViewById(R.id.grade);
            star.setText(stars);//显示星星数目
            grades.setText(grade);//显示等级
            //activity连接 到view 和controller
         GiftController controller = new GiftController((GiftView) this.findViewById(R.id.return1122), this);
          //日历控制器将截获日历表的事件
               ((GiftView) this.findViewById(R.id.return1122)).setGiftListeners(controller);
        }

        @Override//结束礼物界面
        public void onClickGiftSuccess(){
           Intent intent=new Intent(this,MainActivity.class);
           startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            GiftActivity.this.finish();

        }
    }

