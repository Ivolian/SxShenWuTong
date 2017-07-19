package com.unicorn.sxshenwutong.d.spdsp.list;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.d.spdsp.sp.FdsyAct;
import com.unicorn.sxshenwutong.d.spdsp.sp.SycxbgAct;

public class SpdspAdapter extends BaseQuickAdapter<SimpleSpdsp, BaseViewHolder> {

    public SpdspAdapter() {
        super(R.layout.item_spdsp);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final SimpleSpdsp simpleSpdsp) {
        viewHolder.setText(R.id.tvBt, "标题: " + simpleSpdsp.getBt());

        viewHolder.setText(R.id.tvSqrq, "申请日期: " + simpleSpdsp.getSqrq());
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());


        viewHolder.getView(R.id.tvDsp).setOnClickListener(v -> {
            Intent intent = new Intent(mContext, simpleSpdsp.getLcmc().equals("法定事由审批") ? FdsyAct.class : SycxbgAct.class);
            intent.putExtra(Key.AJBS, simpleSpdsp.getAjbs());
            intent.putExtra(Key.LCID, simpleSpdsp.getLcid());
            intent.putExtra(Key.SPID, simpleSpdsp.getSpid());
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