package com.unicorn.sxshenwutong.c.home;

import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.c.home.entity.HomeItem;
import com.unicorn.sxshenwutong.d.jasc.JascListAct;
import com.unicorn.sxshenwutong.d.spdsp.list.SpdspListAct;
import com.unicorn.sxshenwutong.d.spdb.list.spdb.SpdbListAct;

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
                Intent intent = new Intent(mContext, SpdspListAct.class);
                intent.putExtra(Key.TITLE, homeItem.getTitle());
                intent.putExtra(Key.LBTYPE, homeItem.getLbtype());
                mContext.startActivity(intent);
                return;
            }

            if (homeItem.getTitle().equals("审判结案审查") || homeItem.getTitle().equals("执行结案审查")){
                Intent intent = new Intent(mContext, JascListAct.class);
                intent.putExtra(Key.TITLE, homeItem.getTitle());
                intent.putExtra(Key.LBTYPE, homeItem.getLbtype());
                mContext.startActivity(intent);
                return;
            }



            Intent intent = new Intent(mContext, SpdbListAct.class);
            intent.putExtra(Key.TITLE, homeItem.getTitle());
            intent.putExtra(Key.LBTYPE, homeItem.getLbtype());
            mContext.startActivity(intent);
        });
    }


}