package com.example.oyj.myapplication.model;

import java.io.Serializable;
//系列化类
public class User implements Serializable
{private static final long serialVersionUID = 1L;
    public int day;
    public int date;
    public star[] stars;
    public User(){
        this.stars= new star[21]; this.day=1;
        for(int i=0;i<21;++i) {stars[i]=new star();}
    }
  public void addday(){++day;}

}
