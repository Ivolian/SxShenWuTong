package com.unicorn.sxshenwutong.b.userType.network;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseSubmitter;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.SimpleResponse;

import java.util.HashMap;

public class UserTypeSubmitter extends BaseSubmitter<SimpleResponse> {

    private String userTypeDm;

    public UserTypeSubmitter(String userTypeDm) {
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

    @Override
    protected SimpleResponse map(Response response) {
        String ydbaKey = response.getParameters().get(Key.YDBAKEY);
        return gson.fromJson(ydbaKey, SimpleResponse.class);
    }

}
