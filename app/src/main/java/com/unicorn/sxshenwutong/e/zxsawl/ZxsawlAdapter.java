package com.unicorn.sxshenwutong.e.zxsawl;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;
import com.unicorn.sxshenwutong.e.base.AjxxRender;
import com.unicorn.sxshenwutong.f.BaseHelper;

class ZxsawlAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    ZxsawlAdapter() {
        super(R.layout.item_zxsawl);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(BaseHelper.bg(mContext));
        new AjxxRender(viewHolder, ajxx).render();
    }

}