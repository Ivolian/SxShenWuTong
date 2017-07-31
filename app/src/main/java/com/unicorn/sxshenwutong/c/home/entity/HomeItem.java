package com.unicorn.sxshenwutong.c.home.entity;

import java.io.Serializable;

public class HomeItem implements Serializable{

    private String title;
    private int drawableRes;
    private int count;
    private String lbtype;

    public HomeItem(String title, int count, String lbtype) {
        this.title = title;
        this.count = count;
        this.lbtype = lbtype;
    }

    public HomeItem(String title, int drawableRes, int count, String lbtype) {
        this.title = title;
        this.drawableRes = drawableRes;
        this.count = count;
        this.lbtype = lbtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLbtype() {
        return lbtype;
    }

    public void setLbtype(String lbtype) {
        this.lbtype = lbtype;
    }
}
