package com.unicorn.sxshenwutong.simple.lawys;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;

class LawysAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    LawysAdapter() {
        super(R.layout.item_lawys);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Ajxx ajxx) {
        // 案号、案由、立案日期、原告、被告
        viewHolder.setText(R.id.tvAhqc, ajxx.getAhqc());
        viewHolder.setText(R.id.tvLaaymc, ajxx.getLaaymc());
        viewHolder.setText(R.id.tvLarq, ajxx.getLarq());
        viewHolder.setText(R.id.tvDyyg, ajxx.getDyyg());
        viewHolder.setText(R.id.tvDybg, ajxx.getDybg());
    }
}