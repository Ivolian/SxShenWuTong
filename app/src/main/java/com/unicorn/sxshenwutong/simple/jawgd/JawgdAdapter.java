package com.unicorn.sxshenwutong.simple.jawgd;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;

class JawgdAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    JawgdAdapter() {
        super(R.layout.item_jawgd);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Ajxx ajxx) {
        // 案号、案由、结案日期、原告、被告
        viewHolder.setText(R.id.tvAhqc, ajxx.getAhqc());
        viewHolder.setText(R.id.tvLaaymc, ajxx.getLaaymc());
        viewHolder.setText(R.id.tvJarq, ajxx.getJarq());
        viewHolder.setText(R.id.tvDyyg, ajxx.getDyyg());
        viewHolder.setText(R.id.tvDybg, ajxx.getDybg());
    }
}