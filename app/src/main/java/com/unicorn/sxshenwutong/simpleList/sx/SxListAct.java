package com.unicorn.sxshenwutong.simpleList.sx;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.a.base.AjxxListAct;
import com.unicorn.sxshenwutong.db.Ajxx;

public class SxListAct extends AjxxListAct{

    @Override
    protected BaseQuickAdapter<Ajxx, BaseViewHolder> getAdapter() {
        return new SxAdapter();
    }

}
