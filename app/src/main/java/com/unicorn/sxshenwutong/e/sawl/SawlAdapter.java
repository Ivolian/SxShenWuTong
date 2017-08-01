package com.unicorn.sxshenwutong.e.sawl;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

class SawlAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    SawlAdapter() {
        super(R.layout.item_sawl);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Ajxx ajxx) {
        // 案号、案由、收案日期、原告、被告
        viewHolder.setText(R.id.tvAhqc, ajxx.getAhqc());
        viewHolder.setText(R.id.tvLaaymc, ajxx.getLaaymc());
        viewHolder.setText(R.id.tvSarq, ajxx.getSarq());
        viewHolder.setText(R.id.tvDyyg, ajxx.getDyyg());
        viewHolder.setText(R.id.tvDybg, ajxx.getDybg());
    }

}