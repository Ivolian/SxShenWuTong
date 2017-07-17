package com.unicorn.sxshenwutong.c.home;

import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.c.home.entity.HomeItem;
import com.unicorn.sxshenwutong.c.spdsp.SpdspAct;
import com.unicorn.sxshenwutong.list.ListAct2;

public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {

    public HomeAdapter() {
        super(R.layout.item_home);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final HomeItem homeItem) {
        String text = homeItem.getTitle() + (homeItem.getCount() == -1 ? "" : "(" + homeItem.getCount() + ")");
        viewHolder.setText(R.id.tvText, text);
        viewHolder.setImageResource(R.id.ivImage, homeItem.getDrawableRes());

        setOnClick(viewHolder,homeItem);
    }


    private void setOnClick(BaseViewHolder viewHolder,HomeItem homeItem){
        viewHolder.getView(R.id.item).setOnClickListener(v -> {
            if (homeItem.getCount() == -1) {
                return;
            }
            if (homeItem.getTitle().equals("审判待审批")){
                Intent intent = new Intent(mContext, SpdspAct.class);
                intent.putExtra(Key.TITLE, homeItem.getTitle());
                intent.putExtra(Key.LBTYPE, homeItem.getLbtype());
                mContext.startActivity(intent);
                return;
            }

            Intent intent = new Intent(mContext, ListAct2.class);
            intent.putExtra(Key.TITLE, homeItem.getTitle());
            intent.putExtra(Key.LBTYPE, homeItem.getLbtype());
            mContext.startActivity(intent);
        });
    }


}