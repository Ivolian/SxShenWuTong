package com.unicorn.sxshenwutong.e.dtkt;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.f.BaseHelper;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

class DtktAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    DtktAdapter() {
        super(R.layout.item_dtkt);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(BaseHelper.bg(mContext));
        new DtktRenderer(viewHolder, ajxx).render();
    }

}