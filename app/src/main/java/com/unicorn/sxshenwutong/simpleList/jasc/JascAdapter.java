package com.unicorn.sxshenwutong.simpleList.jasc;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;

class JascAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    JascAdapter() {
        super(R.layout.item_jasc);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        //   案号、案由、立案日期、原告、被告、结案日期、结案方式
        viewHolder.setText(R.id.tvAhqc, ajxx.getAhqc());
        viewHolder.setText(R.id.tvLaaymc, ajxx.getLaaymc());
        viewHolder.setText(R.id.tvLarq, ajxx.getLarq());
        viewHolder.setText(R.id.tvDyyg, ajxx.getDyyg());
        viewHolder.setText(R.id.tvDybg, ajxx.getDybg());
        viewHolder.setText(R.id.tvJarq, ajxx.getJarq());
        viewHolder.setText(R.id.tvJafsmc, ajxx.getJafsmc());
    }

}