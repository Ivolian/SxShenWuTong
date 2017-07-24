package com.unicorn.sxshenwutong.d.spdb.list.ajcl.entity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;

public class AjclListAdapter extends BaseQuickAdapter<Ajcl, BaseViewHolder> {

    public AjclListAdapter() {
        super(R.layout.item_ajspsq);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajcl ajcl) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());
        viewHolder.setText(R.id.tvBt, "文件名称: " + ajcl.getWjmc());
    }

    private Drawable bg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(mContext, R.color.md_grey_300));
        return gradientDrawable;
    }

}