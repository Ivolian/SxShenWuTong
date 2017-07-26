package com.unicorn.sxshenwutong.d.jasc;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.BaseHelper;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

public class JascAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    public JascAdapter() {
        super(R.layout.item_jasc);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(BaseHelper.bg(mContext));

        new JascRenderer(viewHolder, ajxx).render();
    }

}