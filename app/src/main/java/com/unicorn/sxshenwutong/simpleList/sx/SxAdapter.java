package com.unicorn.sxshenwutong.simpleList.sx;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;

class SxAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    SxAdapter() {
        super(R.layout.item_sx);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        // 案号、案由、立案日期、原告、被告
        viewHolder.setText(R.id.tvAhqc, ajxx.getAhqc());
        viewHolder.setText(R.id.tvLaaymc, ajxx.getLaaymc());
        viewHolder.setText(R.id.tvLarq, ajxx.getLarq());
        viewHolder.setText(R.id.tvDyyg, ajxx.getDyyg());
        viewHolder.setText(R.id.tvDybg, ajxx.getDybg());
        // 法定审理天数、延长审限天数、扣除审限天数、预结日期
        viewHolder.setText(R.id.tvFdslts, ajxx.getFdslts());
        viewHolder.setText(R.id.tvYcsxts, ajxx.getYcsxts());
        viewHolder.setText(R.id.tvKcsxts, ajxx.getKcsxts());
        viewHolder.setText(R.id.tvYjrq, ajxx.getYjrq());
    }

}