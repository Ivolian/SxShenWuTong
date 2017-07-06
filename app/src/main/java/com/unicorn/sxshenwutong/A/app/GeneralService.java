package com.unicorn.sxshenwutong.A.app;

import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.A.app.entity.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GeneralService {

    @GET("request.shtml")
    Observable<Response<LinkedTreeMap<String, String>>> get(@Query("params") String params);

}