package com.unicorn.sxshenwutong.db.ajspSq;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.ajspSq.entity.Ajsp;

class AjspSqListAdapter extends BaseQuickAdapter<Ajsp, BaseViewHolder> {

    AjspSqListAdapter() {
        super(R.layout.item_ajsp_sq);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajsp ajsp) {
        viewHolder.setText(R.id.tvBt, ajsp.getBt());
        viewHolder.setText(R.id.tvSqrmc, ajsp.getSqrmc());
        viewHolder.setText(R.id.tvSqrq, ajsp.getSqrq());
    }

}