package com.unicorn.sxshenwutong.news;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.news.entity.News;

class NewsAdapter extends BaseQuickAdapter<News, BaseViewHolder> {

    NewsAdapter() {
        super(R.layout.item_db);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final News news) {
        // 案号、案由、立案日期、原告、被告
//        viewHolder.setText(R.id.tvAhqc, news.getAhqc());
//        viewHolder.setText(R.id.tvLaaymc, news.getLaaymc());
//        viewHolder.setText(R.id.tvLarq, news.getLarq());
//        viewHolder.setText(R.id.tvDyyg, news.getDyyg());
//        viewHolder.setText(R.id.tvDybg, news.getDybg());
    }


}