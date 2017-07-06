package com.unicorn.sxshenwutong.app;

import com.google.gson.internal.LinkedTreeMap;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GeneralService {

    @GET("request.shtml")
    Observable<Response<LinkedTreeMap<String, String>>> get(@Query("params") String params);

}