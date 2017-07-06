package com.unicorn.sxshenwutong.list;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;

public class ModelAdapter extends BaseQuickAdapter<Model, BaseViewHolder> {

    public ModelAdapter() {
        super(R.layout.item_list);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Model model) {
        viewHolder.setText(R.id.tvText,model.getAhqc());
    }

}