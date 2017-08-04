package com.unicorn.sxshenwutong.news.newsList;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.ListResponse;
import com.unicorn.sxshenwutong.a.base.RefreshFra;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.GeneralService;
import com.unicorn.sxshenwutong.a.network.ParamsInitializer;
import com.unicorn.sxshenwutong.a.network.entity.Params;
import com.unicorn.sxshenwutong.news.newsList.entity.News;
import com.unicorn.sxshenwutong.news.newsType.entity.NewsType;

import java.util.HashMap;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;
import static com.unicorn.sxshenwutong.a.constant.Key.YDBAKEY;

public class NewsListFra extends RefreshFra<News> {

    @Override
    protected int layoutResId() {
        return R.layout.fra_news_list;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected BaseQuickAdapter<News, BaseViewHolder> getAdapter() {
        return new NewsAdapter();
    }



    @Inject
    ParamsInitializer paramsInitializer;

    private String params() {
        Params params = new Params();
        paramsInitializer.initParams(params, "getNewsList", parameters());
        return params.toString();
    }

    protected HashMap<String, Object> parameters() {
        NewsType newsType = (NewsType) getArguments().getSerializable("newsType");
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("page", pageNo);
        parameters.put("pageSize", PAGE_SIZE);
        parameters.put("newstype", newsType.getType());
        parameters.put("newstypeid", newsType.getId());
        return parameters;
    }

    @Inject
    GeneralService generalService;

    @Override
    protected Observable<ListResponse<News>> load() {
        return generalService.get(params())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(response -> response.getCode().equals(SUCCESS_CODE))
                .map(response -> response.getParameters().get(YDBAKEY))
                .filter(s -> s != null)
                .map(this::gson);
    }

    @Inject
    protected Gson gson;

     protected ListResponse<News> gson(String ydbaKey){
         return gson.fromJson(ydbaKey, new TypeToken<ListResponse<News>>() {
         }.getType());
     }

}
