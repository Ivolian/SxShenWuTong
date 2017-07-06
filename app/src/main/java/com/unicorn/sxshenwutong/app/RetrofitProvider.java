package com.unicorn.sxshenwutong.app;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@com.unicorn.sxshenwutong.dagger.App
public class RetrofitProvider {

    @Inject
    public RetrofitProvider() {
    }

    private String baseUrl = "http://1.85.16.50:8081/ydba/";

    public Retrofit provide() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}