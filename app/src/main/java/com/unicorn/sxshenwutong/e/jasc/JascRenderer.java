package com.unicorn.sxshenwutong.e.jasc;

import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.e.base.AjxxRender;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

class JascRenderer extends AjxxRender {

    JascRenderer(BaseViewHolder baseViewHolder, Ajxx ajxx) {
        super(baseViewHolder, ajxx);
    }

    @Override
    public void render() {
        super.render();
        viewHolder.setText(R.id.tvJarq, "结案日期 :" + entity.getJarq());
        viewHolder.setText(R.id.tvJafsmc, "结案方式 :" + entity.getJafsmc());
    }

}
