package com.example.quixoteinternshiptask;

public class Notetype {
    int mImg;
    int mImg1;
    int mImg2;
    String ntitle;
    String ndescription;
    String ninfo;
    public Notetype(){
    }
    public Notetype(int mImg, String ntitle, String ndescription,String ninfo,int mImg1,int mImg2) {
        this.mImg = mImg;
        this.mImg1 = mImg1;
        this.mImg2 = mImg2;
        this.ntitle = ntitle;
        this.ndescription = ndescription;
        this.ninfo = ninfo;
    }
    public int getmImg() {
        return mImg;
    }
    public void setmImg(int mImg) {
        this.mImg = mImg;
    }
    public String getNtitle() {
        return ntitle;
    }
    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }
    public String getNdescription() {
        return ndescription;
    }
    public void setNdescription(String ndescription) {
        this.ndescription = ndescription;
    }
    public String getNinfo() {
        return ninfo;
    }
    public void setNinfo(String ninfo) {
        this.ninfo = ninfo;
    }
    public int getmImg1() {
        return mImg1;
    }
    public void setmImg1(int mImg1) {
        this.mImg1 = mImg1;
    }
    public int getmImg2() {
        return mImg2;
    }
    public void setmImg2(int mImg2) {
        this.mImg2 = mImg2;
    }
}
