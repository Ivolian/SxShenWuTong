package com.unicorn.sxshenwutong.e.base;

import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseRenderer;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

public class AjxxRender extends BaseRenderer<Ajxx> {

    public AjxxRender(BaseViewHolder viewHolder, Ajxx entity) {
        super(viewHolder, entity);
    }

    @Override
    public void render() {
        viewHolder.setText(R.id.tvAhqc, "案号: " + entity.getAhqc());
        viewHolder.setText(R.id.tvDyyg, "原告: " + entity.getDyyg());
        viewHolder.setText(R.id.tvDybg, "被告: " + entity.getDybg());
        viewHolder.setText(R.id.tvLaaymc, "案由: " + entity.getLaaymc());
        viewHolder.setText(R.id.tvLarq, "立案日期 :" + entity.getLarq());
    }

}
