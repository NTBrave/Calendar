package com.example.oyj.myapplication.model;
import android.app.Application;
import android.content.SharedPreferences;
import com.example.oyj.myapplication.activity.implementation.MainActivity;

import java.io.IOException;
import java.lang.String;
//全局变量
public class AppData extends Application {

    private String Theme;
    private String  Grade;
    private String  STARS;
    private  SharedPreferences pf;
    private User user;
    private int button_id;
    private MainActivity main;
    @Override
    public void onCreate() {//数据初始化 ，文件里有就读取，没有，就创建文件。
        super.onCreate();
        String stars="0",theme22="boy",grade="0";
        pf = getSharedPreferences("ALLdata", 0);
        String str = pf.getString("User", "");
        if(str=="") {
            user=new User();
            try {
                str = SerializeUtils.serialize(user);}
            catch (IOException e){};

            SharedPreferences pf = getSharedPreferences("ALLdata", 0);

            SharedPreferences.Editor edit2 = pf.edit();
            edit2.putString("User",str);
            edit2.putString("NumbersOfStars","0");
            edit2.putString("Theme","boy");
            edit2.putString("Grade","0");

            edit2.commit();
            this.Grade="0";
            this.Theme="boy";
            this.STARS="0";
        }
        else {
         stars = pf.getString("NumbersOfStars","");
         theme22 = pf.getString("Theme","");
         grade = pf.getString("Grade","");
         str = pf.getString("User", "");}

//        user=new User();
//        String str=null;
//        try {
//            str = SerializeUtils.serialize(user);}
//        catch (IOException e){};
//
//        SharedPreferences pf = getSharedPreferences("ALLdata", 0);
//        SharedPreferences.Editor edit2 = pf.edit();
//        edit2.putString("User",str);
//        edit2.commit();

//        SharedPreferences pf2 = getSharedPreferences("aa", 0);
//        String str= pf2.getString("User", "");
        try {
            this.user = (User) SerializeUtils.serializeToObject(str);
        } catch (IOException e) {
        } catch (ClassNotFoundException e2) {
        }
        this.Grade=grade;
        this.Theme=theme22;
        this.STARS=stars;
    }

    public String getTHeme() {
        return Theme;
    }

    public void setTHeme(String score) {
        this.Theme= score;
        SharedPreferences.Editor edit1 = pf.edit();
        edit1.putString("Theme",score);
        edit1.commit();
    }

    public String getGrade() {return Grade; }
    public void setGrade(String grade) {
        this.Grade= grade;
        SharedPreferences.Editor edit2 = pf.edit();
        edit2.putString("Grade",grade);
        edit2.commit();
    }

    public String getSTARS() {return STARS; }
    public void setSTARS(String score) {
        this.STARS= score;
        SharedPreferences.Editor edit2 = pf.edit();
        edit2.putString("NumbersOfStars",score);
        edit2.commit();
        this.setGrade(String.valueOf(Integer.valueOf(score)/20));
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user1 ){
        this.user =user1;

    }
    //保存新的User到文件
    public void saveUser() {
        String New_str = null;
        try {
            New_str = SerializeUtils.serialize(user);}
        catch (IOException e){};
        SharedPreferences.Editor edit2 = pf.edit();
        edit2.putString("User",New_str);
        edit2.commit();
    }
    public void setMain(MainActivity m)
    {main =m;}
    public MainActivity getMain(){return main;}
    //从文件下载新的
   /* public void loadUser(){
            String str = null;
            SharedPreferences pf = null;
            pf = getSharedPreferences("ALLdata", 0);
            str = pf.getString("User", "");
            try {
                this.user = (User) SerializeUtils.serializeToObject(str);
            } catch (IOException e) {
            } catch (ClassNotFoundException e2) {
            }
        }*/


        public int getButton_id(){return button_id;}
        public void setButton_id(int i){button_id=i;}
}
