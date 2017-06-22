package com.unicorn.sxshenwutong;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface BaseService {

    @GET("request.shtml")
    Observable<Object> test(@Query("params") String params);

}