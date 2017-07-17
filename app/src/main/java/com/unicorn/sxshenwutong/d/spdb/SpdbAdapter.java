package com.unicorn.sxshenwutong.d.spdb;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.d.spdb.sxbgSq.SxbgSqAct;
import com.unicorn.sxshenwutong.d.spdb.sycxbgSq.SycxbgSqAct;

public class SpdbAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    public SpdbAdapter() {
        super(R.layout.item_spdb);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());

        viewHolder.setText(R.id.tvAhqc, "案号: " + ajxx.getAhqc());
        viewHolder.setText(R.id.tvDyyg, "原告: " + ajxx.getDyyg());
        viewHolder.setText(R.id.tvDybg, "被告: " + ajxx.getDybg());
        viewHolder.setText(R.id.tvLaaymc, "案由: " + ajxx.getLaaymc());
        viewHolder.setText(R.id.tvLarq, "立案日期 :" + ajxx.getLarq());

        viewHolder.getView(R.id.tvCxbg).setOnClickListener(v -> {
            Intent intent = new Intent(mContext, SycxbgSqAct.class);
            intent.putExtra(Key.AJBS, ajxx.getAjbs());
            mContext.startActivity(intent);
        });
        viewHolder.getView(R.id.tvSxbg).setOnClickListener(v -> {
            Intent intent = new Intent(mContext, SxbgSqAct.class);
            intent.putExtra(Key.AJBS, ajxx.getAjbs());
            mContext.startActivity(intent);
        });
    }

    private Drawable bg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(mContext, R.color.md_grey_300));
        return gradientDrawable;
    }

}