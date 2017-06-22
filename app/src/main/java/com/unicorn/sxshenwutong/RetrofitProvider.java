package com.unicorn.sxshenwutong;

import java.util.concurrent.TimeUnit;



import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {

    private String baseUrl = "http://1.85.16.50:8081/ydba/";

    public Retrofit provide() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = okHttpClientBuilder
                .connectTimeout(1, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}