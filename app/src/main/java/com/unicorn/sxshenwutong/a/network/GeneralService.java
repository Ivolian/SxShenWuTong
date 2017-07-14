package com.unicorn.sxshenwutong.a.network;

import com.unicorn.sxshenwutong.a.network.entity.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GeneralService {

    @GET("request.shtml")
    Observable<Response> get(@Query("params") String params);

}