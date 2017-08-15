package com.unicorn.sxshenwutong.news.newsList;

import android.content.Intent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.news.news.NewsAct;
import com.unicorn.sxshenwutong.news.news.entity.News;

class NewsAdapter extends BaseQuickAdapter<News, BaseViewHolder> {

    NewsAdapter() {
        super(R.layout.item_news);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final News news) {
        String imgUrl = App.baseUrl() + news.getImageurl();
        ImageView imageView = viewHolder.getView(R.id.ivImage);
        Glide.with(mContext).load(imgUrl).into(imageView);

        viewHolder.setText(R.id.tvTitle, news.getTitle());
        viewHolder.setText(R.id.tvPubDate, news.getPubdate());

        viewHolder.setOnClickListener(R.id.item, v -> {
            Intent intent = new Intent(mContext, NewsAct.class);
            intent.putExtra(Key.NEWS, news);
            mContext.startActivity(intent);
        });
    }

}