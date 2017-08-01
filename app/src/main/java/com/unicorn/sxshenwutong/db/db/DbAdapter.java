package com.unicorn.sxshenwutong.db.db;

import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.d.ajcl.AjclListAct;
import com.unicorn.sxshenwutong.d.ajws.AjwsListAct;
import com.unicorn.sxshenwutong.db.Ajxx;
import com.unicorn.sxshenwutong.db.list.ajsqsp.AjspsqListAct;

class DbAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    DbAdapter() {
        super(R.layout.item_db);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajxx ajxx) {
        // 案号、案由、立案日期、原告、被告
        viewHolder.setText(R.id.tvAhqc, "案号: " + ajxx.getAhqc());
        viewHolder.setText(R.id.tvLaaymc, "案由: " + ajxx.getLaaymc());
        viewHolder.setText(R.id.tvLarq, "立案日期 :" + ajxx.getLarq());
        viewHolder.setText(R.id.tvDyyg, "原告: " + ajxx.getDyyg());
        viewHolder.setText(R.id.tvDybg, "被告: " + ajxx.getDybg());
        setOnClick(viewHolder, ajxx);
    }

    private void setOnClick(BaseViewHolder viewHolder, Ajxx ajxx) {
        viewHolder.setOnClickListener(R.id.tvAjspsq, v -> {
            Intent intent = new Intent(mContext, AjspsqListAct.class);
            intent.putExtra(Key.TITLE, "案件审批申请");
            intent.putExtra(Key.LBTYPE, "ajspsqlist");
            intent.putExtra(Key.AJBS, ajxx.getAjbs());
            mContext.startActivity(intent);
        });
        viewHolder.setOnClickListener(R.id.tvAjws, v -> {
            Intent intent = new Intent(mContext, AjwsListAct.class);
            intent.putExtra(Key.TITLE, "案件文书");
            intent.putExtra(Key.LBTYPE, "ajwslist");
            intent.putExtra(Key.AJBS, ajxx.getAjbs());
            mContext.startActivity(intent);
        });
        viewHolder.setOnClickListener(R.id.tvAjcl, v -> {
            Intent intent = new Intent(mContext, AjclListAct.class);
            intent.putExtra(Key.TITLE, "案件材料");
            intent.putExtra(Key.LBTYPE, "ajcllist");
            intent.putExtra(Key.AJBS, ajxx.getAjbs());
            mContext.startActivity(intent);
        });
    }

}