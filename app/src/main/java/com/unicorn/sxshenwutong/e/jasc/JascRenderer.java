package com.unicorn.sxshenwutong.e.jasc;

import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseRenderer;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

/*
  需要展示的字段:
  案号、案由、立案日期、原告、被告、结案日期、结案方式
   */
class JascRenderer extends BaseRenderer<Ajxx> {

    JascRenderer(BaseViewHolder baseViewHolder, Ajxx ajxx) {
        super(baseViewHolder, ajxx);
    }

    @Override
    public void render() {
        viewHolder.setText(R.id.tvAhqc, entity.getAhqc());
        viewHolder.setText(R.id.tvLaaymc, entity.getLaaymc());
        viewHolder.setText(R.id.tvLarq, entity.getLarq());
        viewHolder.setText(R.id.tvDyyg, entity.getDyyg());
        viewHolder.setText(R.id.tvDybg, entity.getDybg());
        viewHolder.setText(R.id.tvJarq, entity.getJarq());
        viewHolder.setText(R.id.tvJafsmc, entity.getJafsmc());
    }

}
