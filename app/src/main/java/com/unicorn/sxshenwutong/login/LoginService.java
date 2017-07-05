package com.unicorn.sxshenwutong.login;

import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.general.Response;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface LoginService {

    @GET("request.shtml")
    Observable<Response<LinkedTreeMap<String, String>>> login(@Query("params") String params);

}