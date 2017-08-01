package com.unicorn.sxshenwutong.e.jasc;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.a.base.AjxxListAct;
import com.unicorn.sxshenwutong.db.Ajxx;

public class JascListAct extends AjxxListAct {

    @Override
    protected BaseQuickAdapter<Ajxx, BaseViewHolder> getAdapter() {
        return new JascAdapter();
    }

}
