package com.unicorn.sxshenwutong.c.home;

import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.c.home.entity.HomeItem;
import com.unicorn.sxshenwutong.db.db.DbListAct;
import com.unicorn.sxshenwutong.d.spdsp.list.SpdspListAct;
import com.unicorn.sxshenwutong.e.dtkt.DtktListAct;
import com.unicorn.sxshenwutong.e.jasc.JascListAct;
import com.unicorn.sxshenwutong.e.sx.SxListAct;

class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {

    HomeAdapter() {
        super(R.layout.item_home);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final HomeItem homeItem) {
        String text = homeItem.getTitle() + "(" + homeItem.getCount() + ")";
        viewHolder.setText(R.id.tvText, text);
        viewHolder.setImageResource(R.id.ivImage, homeItem.getDrawableRes());

        setOnClick(viewHolder, homeItem);
    }

    private void setOnClick(BaseViewHolder viewHolder, HomeItem homeItem) {
        viewHolder.getView(R.id.item).setOnClickListener(v -> {
            Class actClass = getActClass(homeItem);
            if (actClass != null) {
                Intent intent = new Intent(mContext, actClass);
                intent.putExtra(Key.TITLE, homeItem.getTitle());
                intent.putExtra(Key.LBTYPE, homeItem.getLbtype());
                mContext.startActivity(intent);
            }
        });
    }

    private Class getActClass(HomeItem homeItem) {
        String title = homeItem.getTitle();
        if (title.contains("待办")) {
            return DbListAct.class;
        }
        if (title.contains("待审批")) {
            return SpdspListAct.class;
        }
        if (title.contains("结案审查")) {
            return JascListAct.class;
        }
        if (title.contains("超审限")) {
            return SxListAct.class;
        }
        if (title.equals("当天开庭")) {
            return DtktListAct.class;
        }
        return null;
    }

}