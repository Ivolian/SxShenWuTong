package com.unicorn.sxshenwutong.simpleList.dtkt;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;

class DtktAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    DtktAdapter() {
        super(R.layout.item_dtkt);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        // 案号、案由、原告、被告
        // todo 开庭时间、开庭地点
        viewHolder.setText(R.id.tvAhqc, ajxx.getAhqc());
        viewHolder.setText(R.id.tvLaaymc, ajxx.getLaaymc());
        viewHolder.setText(R.id.tvDyyg, ajxx.getDyyg());
        viewHolder.setText(R.id.tvDybg, ajxx.getDybg());
    }

}