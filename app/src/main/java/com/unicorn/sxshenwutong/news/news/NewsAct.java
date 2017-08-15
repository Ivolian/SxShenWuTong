package com.unicorn.sxshenwutong.news.news;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.news.news.entity.News;
import com.unicorn.sxshenwutong.news.news.entity.NewsResponse;
import com.unicorn.sxshenwutong.news.news.network.NewsFetcher;

import butterknife.BindView;
import rx.Subscriber;

public class NewsAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_news;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        News news = (News) getIntent().getSerializableExtra(Key.NEWS);
        setTitle(news);
        fetchNews(news);
    }

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    private void setTitle(News news) {
        tvTitle.setText(news.getTitle());
    }

    private void fetchNews(News news) {
        new NewsFetcher(news.getId()).start().subscribe(
                new Subscriber<NewsResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsResponse newsResponse) {
                        initWebView(newsResponse.getNews());
                    }
                }
        );
    }

    @BindView(R.id.webView)
    WebView webView;

    private void initWebView(News news) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(news.getContent(), "text/html; charset=UTF-8", null);
    }

}
