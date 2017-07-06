package com.unicorn.sxshenwutong.c.home;

import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.list.ListAct;
import com.unicorn.sxshenwutong.R;

public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {

    public HomeAdapter() {
        super(R.layout.item_home);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final HomeItem homeItem) {
        String text = homeItem.getText() + (homeItem.getCount() == -1 ? "" : "(" + homeItem.getCount() + ")");
        viewHolder.setText(R.id.tvText, text);
        viewHolder.setImageResource(R.id.ivImage, homeItem.getDrawableRes());
        viewHolder.getView(R.id.item).setOnClickListener(v -> mContext.startActivity(new Intent(mContext, ListAct.class)));
    }

}