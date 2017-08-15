package com.unicorn.sxshenwutong.db.ajws.select;

import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hwangjr.rxbus.RxBus;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.db.ajws.base.entity.Ajws;
import com.unicorn.sxshenwutong.db.ajws.base.BaseAjwsListAct;

import java.util.List;


public class AjwsSelectListAct extends BaseAjwsListAct {

    private AjwsSelectAdapter adapter;

    @Override
    protected BaseQuickAdapter<Ajws, BaseViewHolder> getAdapter() {
        return adapter = new AjwsSelectAdapter();
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        setOperation("确定", aVoid -> postSelectedAjwsList());
    }

    private void postSelectedAjwsList() {
        List<Ajws> selectedAjwsList = adapter.getSelectedAjwsList();
        if (selectedAjwsList.size() == 0) {
            ToastUtils.showShort("至少选择一项案件文书");
            return;
        }
        RxBus.get().post(RxBusTag.SELECT_AJWS, selectedAjwsList);
        finish();
    }

}
