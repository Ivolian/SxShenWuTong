package com.unicorn.sxshenwutong;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.list.Model;

public class ModelAdapter extends BaseQuickAdapter<Model, BaseViewHolder> {

    public ModelAdapter() {
        super(R.layout.item_home);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Model homeItem) {

    }

}