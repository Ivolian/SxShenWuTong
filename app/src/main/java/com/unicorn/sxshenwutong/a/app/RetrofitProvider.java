package com.unicorn.sxshenwutong.a.app;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@com.unicorn.sxshenwutong.a.dagger.App
public class RetrofitProvider {

    @Inject
    public RetrofitProvider() {
    }

    public Retrofit provide() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(App.baseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}