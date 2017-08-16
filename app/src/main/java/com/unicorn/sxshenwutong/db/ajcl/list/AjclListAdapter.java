package com.unicorn.sxshenwutong.db.ajcl.list;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.ajcl.list.entity.Ajcl;

class AjclListAdapter extends BaseQuickAdapter<Ajcl, BaseViewHolder> {

    AjclListAdapter() {
        super(R.layout.item_ajcl);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajcl ajcl) {
        viewHolder.setText(R.id.tvWjmc, ajcl.getWjmc());
        viewHolder.setText(R.id.tvScrmc, ajcl.getScrmc());
    }

}