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
import com.unicorn.sxshenwutong.news.newsList.entity.News;

class NewsAdapter extends BaseQuickAdapter<News, BaseViewHolder> {

    NewsAdapter() {
        super(R.layout.item_news);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final News news) {
        String path = App.baseUrl() + news.getImageUrl();
        path =
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1501771102179&di=7b6320bd710c59f7b3197a2a045fefea&imgtype=0&src=http%3A%2F%2Fi3.sinaimg.cn%2Fedu%2F2015%2F0615%2FU1151P42DT20150615120024.png";
        ImageView imageView = viewHolder.getView(R.id.ivImage);
        Glide.with(mContext).load(path).into(imageView);
        viewHolder.setText(R.id.tvTitle, news.getTitle());
        viewHolder.setText(R.id.tvPubDate, news.getPubDate());

        viewHolder.setOnClickListener(R.id.item, v -> {
            Intent intent = new Intent(mContext, NewsAct.class);
            intent.putExtra(Key.NEWS, news);
            mContext.startActivity(intent);
        });
    }

}