package com.unicorn.sxshenwutong.e.jasc;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.f.BaseHelper;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

class JascAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    JascAdapter() {
        super(R.layout.item_jasc);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(BaseHelper.bg(mContext));

        new JascRenderer(viewHolder, ajxx).render();
    }

}