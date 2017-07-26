package com.unicorn.sxshenwutong.d.sx;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.a.base.AjxxListAct;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

// 已超审限 & 即将超审限
public class SxListAct extends AjxxListAct{

    @Override
    protected BaseQuickAdapter<Ajxx, BaseViewHolder> getAdapter() {
        return new SxListAdapter();
    }

}
