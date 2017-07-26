package com.unicorn.sxshenwutong.e.sx;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.BaseHelper;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

class SxListAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    SxListAdapter() {
        super(R.layout.item_sx);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        // set item bg
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(BaseHelper.bg(mContext));

        new SxRenderer(viewHolder, ajxx).render();
    }

}