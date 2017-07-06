package com.unicorn.sxshenwutong.c.home;

import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.list.ListAct;

public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {

    public HomeAdapter() {
        super(R.layout.item_home);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final HomeItem homeItem) {
        String text = homeItem.getText() + (homeItem.getCount() == -1 ? "" : "(" + homeItem.getCount() + ")");
        viewHolder.setText(R.id.tvText, text);
        viewHolder.setImageResource(R.id.ivImage, homeItem.getDrawableRes());
        viewHolder.getView(R.id.item).setOnClickListener(v -> {
            Intent intent = new Intent(mContext, ListAct.class);
            intent.putExtra(Key.TITLE, homeItem.getText());
            mContext.startActivity(intent);
        });
    }

}