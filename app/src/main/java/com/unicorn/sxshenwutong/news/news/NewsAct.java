package com.unicorn.sxshenwutong.news.news;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.news.news.network.NewsFetcher;
import com.unicorn.sxshenwutong.news.newsList.entity.News;

import butterknife.BindView;
import rx.Subscriber;

public class NewsAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_news;
    }

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        News news = (News) getIntent().getSerializableExtra(Key.NEWS);
        tvTitle.setText(news.getTitle());
        fetchNews(news.getId());
    }

    private void fetchNews(String newsId) {
        new NewsFetcher(newsId).start().subscribe(new Subscriber<NewsResponse>() {
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
//        String user_agent = "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; en) AppleWebKit/124 (KHTML, like Gecko) Safari/125.1";
//        webView.getSettings().setUserAgentString(user_agent);
//        webView.loadUrl(infoUrl);
        webView.loadData(news.getContent(), "text/html; charset=UTF-8", null);
    }

}
