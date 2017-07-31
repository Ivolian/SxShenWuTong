package com.unicorn.sxshenwutong.e.jasc;

import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;
import com.unicorn.sxshenwutong.e.base.AjxxRender;

class JascRenderer extends AjxxRender {

    JascRenderer(BaseViewHolder baseViewHolder, Ajxx ajxx) {
        super(baseViewHolder, ajxx);
    }

    /*
    案号、案由、立案日期、原告、被告、结案日期、结案方式
     */

    @Override
    public void render() {
        super.render();
//        viewHolder.setText(R.id.tvJarq, "结案日期 :" + entity.getJarq());
//        viewHolder.setText(R.id.tvJafsmc, "结案方式 :" + entity.getJafsmc());
    }

}
