package com.unicorn.sxshenwutong.d.spdsp.list;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.reflect.TypeToken;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.a.base.ListAct;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.d.spdsp.list.entity.Spdsp;

public class SpdspListAct extends ListAct<Spdsp> {

    @Override
    protected boolean useRxBus() {
        return true;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<Spdsp, BaseViewHolder> getAdapter() {
        return new SpdspListAdapter();
    }

    @Override
    protected ListResponse<Spdsp> gson(String ydbaKey) {
        return gson.fromJson(ydbaKey, new TypeToken<ListResponse<Spdsp>>() {
        }.getType());
    }

    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        swipeRefreshLayout.setRefreshing(true);
        loadFirst();
    }

}
