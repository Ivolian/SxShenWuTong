package com.unicorn.sxshenwutong.a.app;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GeneralService2 {

    @GET("request.shtml")
    Observable<com.unicorn.sxshenwutong.a.app.entity.Response> get(@Query("params") String params);

}