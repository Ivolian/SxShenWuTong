package com.unicorn.sxshenwutong.court.data;

import com.unicorn.sxshenwutong.app.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface CourtService {

    @GET("request.shtml")
    Observable<Response> getCourt(@Query("params") String params);

}