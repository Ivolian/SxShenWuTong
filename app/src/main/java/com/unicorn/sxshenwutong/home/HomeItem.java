package com.unicorn.sxshenwutong.home;

import android.support.annotation.DrawableRes;

public class HomeItem {

    private String text;
    private @DrawableRes int drawableRes;

    public HomeItem(String text, int drawableRes) {
        this.text = text;
        this.drawableRes = drawableRes;
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
}
