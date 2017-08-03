package com.unicorn.sxshenwutong.g;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.a.base.ListFra;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.g.entity.News;

public class NewsListFra extends ListFra<News> {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<News, BaseViewHolder> getAdapter() {
        return new NewsAdapter();
    }

    @Override
    protected ListResponse<News> gson(String ydbaKey) {
        return null;
    }

}
