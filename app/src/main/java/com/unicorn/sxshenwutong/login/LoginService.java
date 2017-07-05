package com.unicorn.sxshenwutong.login;

import com.unicorn.sxshenwutong.general.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface LoginService {

    @GET("request.shtml")
    Observable<Response> test(@Query("params") String params);

}