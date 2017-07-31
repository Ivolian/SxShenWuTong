package com.unicorn.sxshenwutong.e.sx;

import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.e.base.AjxxRender;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

class SxRenderer extends AjxxRender {

    SxRenderer(BaseViewHolder viewHolder, Ajxx entity) {
        super(viewHolder, entity);
    }

    @Override
    public void render() {
        super.render();
        viewHolder.setText(R.id.tvFdslts, "法定审理天数 :" + entity.getFdslts());
        viewHolder.setText(R.id.tvYcsxts, "延长审限天数 :" + entity.getYcsxts());
        viewHolder.setText(R.id.tvKcsxts, "扣除审限天数 :" + entity.getKcsxts());
        viewHolder.setText(R.id.tvYjrq, "预结日期 :" + entity.getYjrq());
    }

}
