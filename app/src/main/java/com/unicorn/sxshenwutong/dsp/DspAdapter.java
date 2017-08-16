package com.unicorn.sxshenwutong.dsp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.dsp.entity.Dsp;
import com.unicorn.sxshenwutong.dsp2.FdsyAct;
import com.unicorn.sxshenwutong.dsp2.SycxbgAct;
import com.unicorn.sxshenwutong.dsp2.WsspAct;

class DspAdapter extends BaseQuickAdapter<Dsp, BaseViewHolder> {

    DspAdapter() {
        super(R.layout.item_spdsp);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Dsp dsp) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());
        viewHolder.setText(R.id.tvBt, "标题: " + dsp.getBt());
        viewHolder.setText(R.id.tvSqrq, "申请日期: " + dsp.getSqrq());
        viewHolder.setText(R.id.tvSqrmc, "申请人: " + dsp.getSqrmc());

        viewHolder.getView(R.id.tvSp).setOnClickListener(v -> {
            Intent intent = new Intent(mContext, dsp.getLcmc().equals("法定事由审批") ? FdsyAct.class : dsp.getLcmc().equals("适用程序变更审批") ? SycxbgAct.class : WsspAct.class);
            intent.putExtra(Key.AJBS, dsp.getAjbs());
            intent.putExtra(Key.LCID, dsp.getLcid());
            intent.putExtra(Key.SPID, dsp.getSpid());
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