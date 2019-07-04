package com.example.myapplicationtryfrag;

import android.widget.ImageView;


public class Mydata {
    String t1,t2;
    String img;

    public Mydata(){}


    public Mydata(String img,String t1,String t2){
this.t1=t1;
this.t2=t2;
this.img=img;

    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
