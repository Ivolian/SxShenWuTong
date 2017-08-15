package com.unicorn.sxshenwutong.db.ajws.ajws;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.ajws.base.entity.Ajws;

class AjwsAdapter extends BaseQuickAdapter<Ajws, BaseViewHolder> {

    AjwsAdapter() {
        super(R.layout.item_ajws);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajws ajws) {
        viewHolder.setText(R.id.tvXsmc, ajws.getXsmc());
        viewHolder.setText(R.id.tvCjsj, ajws.getCjsj());
        viewHolder.setOnClickListener(R.id.item, v -> new AjwsHelper(mContext, ajws).viewAjws());
    }

}