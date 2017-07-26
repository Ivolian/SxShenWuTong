package com.unicorn.sxshenwutong;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;


public class BaseHelper {


    public static Drawable bg(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(context, R.color.md_grey_300));
        return gradientDrawable;
    }


}
