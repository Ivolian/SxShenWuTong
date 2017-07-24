package com.unicorn.sxshenwutong.d.spdb.list.spdb;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.b.login.entity.PostTest;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

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

//        viewHolder.getView(R.id.tvSpsq).setOnClickListener(v -> {
//            Intent intent = new Intent(mContext, AjspsqListAct.class);
//            intent.putExtra(Key.TITLE, "案件审批申请");
//            intent.putExtra(Key.LBTYPE, "ajspsqlist");
//            intent.putExtra(Key.AJBS, ajxx.getAjbs());
//            mContext.startActivity(intent);
//        });

        viewHolder.getView(R.id.tvSpsq).setOnClickListener(v -> {

            new PostTest().start(mContext,ajxx.getAjbs());
//
//            Intent intent = new Intent(mContext, AjwsListAct.class);
//            intent.putExtra(Key.TITLE, "案件文书");
//            intent.putExtra(Key.LBTYPE, "ajwslist");
//            intent.putExtra(Key.AJBS, ajxx.getAjbs());
//            mContext.startActivity(intent);
        });


//        viewHolder.getView(R.id.tvCxbg).setOnClickListener(v -> {
//            Intent intent = new Intent(mContext, SycxbgSqAct.class);
//            intent.putExtra(Key.AJBS, ajxx.getAjbs());
//            mContext.startActivity(intent);
//        });
//        viewHolder.getView(R.id.tvSxbg).setOnClickListener(v -> {
//            Intent intent = new Intent(mContext, SxbgSqAct.class);
//            intent.putExtra(Key.AJBS, ajxx.getAjbs());
//            mContext.startActivity(intent);
//        });
    }

    private Drawable bg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(mContext, R.color.md_grey_300));
        return gradientDrawable;
    }

}