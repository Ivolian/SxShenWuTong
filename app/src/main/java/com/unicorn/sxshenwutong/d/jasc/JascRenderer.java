package com.unicorn.sxshenwutong.d.jasc;

import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseRenderer;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

public class JascRenderer extends BaseRenderer<Ajxx> {

    public JascRenderer(BaseViewHolder baseViewHolder, Ajxx ajxx) {
        super(baseViewHolder, ajxx);
    }

    @Override
    public void render() {
        viewHolder.setText(R.id.tvAhqc, "案号: " + entity.getAhqc());
        viewHolder.setText(R.id.tvDyyg, "原告: " + entity.getDyyg());
        viewHolder.setText(R.id.tvDybg, "被告: " + entity.getDybg());
        viewHolder.setText(R.id.tvLaaymc, "案由: " + entity.getLaaymc());
        viewHolder.setText(R.id.tvLarq, "立案日期 :" + entity.getLarq());
        viewHolder.setText(R.id.tvJarq, "结案日期 :" + entity.getJarq());
        viewHolder.setText(R.id.tvJafsmc, "结案方式 :" + entity.getJafsmc());
    }

}
