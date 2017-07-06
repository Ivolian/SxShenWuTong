package com.unicorn.sxshenwutong.c.home;

import android.support.annotation.DrawableRes;

public class HomeItem {

    private String text;
    private @DrawableRes int drawableRes;
    private int count;

    public HomeItem(String text, int drawableRes, int count) {
        this.text = text;
        this.drawableRes = drawableRes;
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

}
