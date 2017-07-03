package com.unicorn.sxshenwutong.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;

public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {

    public HomeAdapter() {
        super(R.layout.item_home);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final HomeItem homeItem) {
        viewHolder.setText(R.id.tvText, homeItem.getText());
        viewHolder.setImageResource(R.id.ivImage, homeItem.getDrawableRes());
    }

}