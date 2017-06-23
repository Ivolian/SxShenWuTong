package com.unicorn.sxshenwutong.userType;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;

public class UserTypeAdapter extends BaseQuickAdapter<UserType, BaseViewHolder> {

    public UserTypeAdapter() {
        super(R.layout.item_user_type);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, UserType userType) {
        LinearLayout linearLayout = viewHolder.getView(R.id.ll);
        linearLayout.setBackground(s(userType));
    }

    private Drawable s(UserType userType){
        int color = ContextCompat.getColor(mContext,userType.isChecked()?
                R.color.login:R.color.md_grey_400);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(100f);
        gradientDrawable.setStroke(5,color,20,4);
      return  gradientDrawable;
    }

}