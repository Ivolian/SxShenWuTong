package com.unicorn.sxshenwutong.e.sawl;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;
import com.unicorn.sxshenwutong.f.BaseHelper;

class SawlAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    SawlAdapter() {
        super(R.layout.item_sawl);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(BaseHelper.bg(mContext));
        new SawlRenderer(viewHolder, ajxx).render();
    }

}