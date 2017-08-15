package com.unicorn.sxshenwutong.db.ajws.ajws;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.db.ajws.base.BaseAjwsListAct;
import com.unicorn.sxshenwutong.db.ajws.base.entity.Ajws;


public class AjwsListAct extends BaseAjwsListAct {

    @Override
    protected BaseQuickAdapter<Ajws, BaseViewHolder> getAdapter() {
        return new AjwsAdapter();
    }

}
