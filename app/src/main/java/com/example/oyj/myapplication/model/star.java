package com.example.oyj.myapplication.model;

import java.io.Serializable;
//序列化类
public class star implements Serializable {
    public int stars;
    public int touch_number;
    public int reward_morning,reward_noon,reward_night;
    public star(){this.stars=0;this.touch_number=0;reward_morning=0;reward_night=0;reward_noon=0; }
    public void setStars(int i){stars=i;}
    public void setTouch_number(int i){touch_number=i;}
}
