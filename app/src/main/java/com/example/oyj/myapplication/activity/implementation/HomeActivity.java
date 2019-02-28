package com.example.oyj.myapplication.activity.implementation;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.example.oyj.myapplication.model.AppData;
import com.example.oyj.myapplication.R;
import com.example.oyj.myapplication.activity.listener.HomeControllerListener;
import com.example.oyj.myapplication.activity.listener.GiftControllerListener;
import com.example.oyj.myapplication.controller.GiftController;
import com.example.oyj.myapplication.controller.HomeController;
import com.example.oyj.myapplication.view.GiftView;
import com.example.oyj.myapplication.view.HomeView;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class HomeActivity extends Activity implements HomeControllerListener,GiftControllerListener{
    protected void onCreate(Bundle savedInstanceState) {//初始化用户信息界面
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AppData application = (AppData) this.getApplication();
        //主题选择
        String Theme = application.getTHeme();
        if (Theme.equals("") || Theme.equals("boy")) setContentView(R.layout.user_boy);
        else if (Theme.equals("girl")) setContentView(R.layout.user_girl);

        Window window = this.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.TOP;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);

        //监听器设置
        HomeController homecontroller = new HomeController((HomeView) this.findViewById(R.id.userpage), this);
        ((HomeView) this.findViewById(R.id.userpage)).setThemeListeners(homecontroller);
        GiftController controller = new GiftController((GiftView) this.findViewById(R.id.TTheme), this);
        ((GiftView) this.findViewById(R.id.TTheme)).setGiftListeners(controller);
        //显示星数和等级
        final TextView User_stars = (TextView) findViewById(R.id.user_stars);
        final TextView User_grades = (TextView) findViewById(R.id.user_grade);
        final TextView Yesterday_stars = (TextView) findViewById(R.id.Yesterday_stars);
        final TextView Today_stars = (TextView) findViewById(R.id.Today_stars);
        User_stars.setText(application.getSTARS());
        User_grades.setText(application.getGrade());
        if(application.getUser().day==1){
            Yesterday_stars.setText(application.getUser().stars[ application.getUser().day-1].stars+"");
        }
        else Yesterday_stars.setText(application.getUser().stars[ application.getUser().day-1-1].stars+"");
        Today_stars.setText(application.getUser().stars[ application.getUser().day-1].stars+"");

    }

    @Override//换主题函数
    public void onClickGiftSuccess(){
        AppData application = (AppData) getApplication();
        String Theme = application.getTHeme();
        if (Theme.equals("boy")) Theme = "girl";
        else if (Theme.equals("girl")) Theme = "boy";
        else Theme = "boy";
        application.setTHeme(Theme);

        AppData application2 = (AppData) getApplication();
        String Theme2 = application2.getTHeme();
        if (Theme2.equals("") || Theme2.equals("boy")) setContentView(R.layout.user_boy);
        else if (Theme2.equals("girl")) setContentView(R.layout.user_girl);

        HomeController homecontroller = new HomeController((HomeView) this.findViewById(R.id.userpage), this);
        ((HomeView) this.findViewById(R.id.userpage)).setThemeListeners(homecontroller);

        GiftController controller = new GiftController((GiftView) this.findViewById(R.id.TTheme), this);
        ((GiftView) this.findViewById(R.id.TTheme)).setGiftListeners(controller);

        final TextView User_stars = (TextView) findViewById(R.id.user_stars);
        final TextView User_grades = (TextView) findViewById(R.id.user_grade);
        final TextView Yesterday_stars = (TextView) findViewById(R.id.Yesterday_stars);
        final TextView Today_stars = (TextView) findViewById(R.id.Today_stars);
        User_stars.setText(application.getSTARS());
        User_grades.setText(application.getGrade());
        if(application.getUser().day==1){
            Yesterday_stars.setText(application.getUser().stars[ application.getUser().day-1].stars+"");
        }
        else Yesterday_stars.setText(application.getUser().stars[ application.getUser().day-1-1].stars+"");
        Today_stars.setText(application.getUser().stars[ application.getUser().day-1].stars+"");

        application2.getMain().update();
    }
    @Override
    public void onClickHomeSuccess(){

        AppData application = (AppData) this.getApplication();
        String Theme=application.getTHeme();
        Intent mIntent = new Intent();//没有任何参数（意图），只是用来传递数据
        mIntent.putExtra("Theme_", String.valueOf(Theme));
        setResult(RESULT_OK, mIntent);
        HomeActivity.this.finish();
    }







}
