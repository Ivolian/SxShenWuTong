package com.unicorn.sxshenwutong.code;

import com.unicorn.sxshenwutong.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface CodeService {

    @GET("request.shtml")
    Observable<Response> getCode(@Query("params") String params);

}