package com.unicorn.sxshenwutong.b.userType;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.b.userType.entity.UserTypeResponse;

import java.util.HashMap;

import javax.inject.Inject;

public class UserTypeFetcher extends BaseFetcher<UserTypeResponse> {

    private String userTypeDm;

    public UserTypeFetcher(String userTypeDm) {
        this.userTypeDm = userTypeDm;
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "setUserType";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("usertype", userTypeDm);
        return parameters;
    }

    @Inject
    Gson gson;

    @Override
    protected UserTypeResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, UserTypeResponse.class);
    }

}
