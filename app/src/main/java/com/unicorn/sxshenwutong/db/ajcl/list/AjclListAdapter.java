package com.unicorn.sxshenwutong.db.ajcl.list;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.ajcl.list.entity.Ajcl;

class AjclListAdapter extends BaseQuickAdapter<Ajcl, BaseViewHolder> {

    AjclListAdapter() {
        super(R.layout.item_ajcl);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajcl ajcl) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());
        viewHolder.setText(R.id.tvWjmc, "文件名称: " + ajcl.getWjmc());
        viewHolder.setText(R.id.tvScrmc, "上传人: " + ajcl.getScrmc());
    }

    private Drawable bg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(mContext, R.color.md_grey_300));
        return gradientDrawable;
    }

}