package com.unicorn.sxshenwutong.spdb.list.ajsqsp;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.spdb.list.ajsqsp.entity.Ajsqsp;

public class AjsqspListAdapter extends BaseQuickAdapter<Ajsqsp, BaseViewHolder> {

    public AjsqspListAdapter() {
        super(R.layout.item_ajspsq);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajsqsp ajsqsp) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());
        viewHolder.setText(R.id.tvBt, "标题: " +ajsqsp.getBt());
        viewHolder.setText(R.id.tvSqrmc, "申请人: " + ajsqsp.getSqrmc());
        viewHolder.setText(R.id.tvSqrq, "申请日期: " + ajsqsp.getSqrq());
    }

    private Drawable bg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(mContext, R.color.md_grey_300));
        return gradientDrawable;
    }

}