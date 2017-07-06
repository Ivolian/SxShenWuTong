package com.unicorn.sxshenwutong.b.userType;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;
import java.util.Map;

public class UserTypeFetcher extends BaseFetcher {

    private String userTypeDm;

    public UserTypeFetcher(String userTypeDm, Callback callback) {
        super(callback);
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
    protected Map<String, Object> parameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("usertype", userTypeDm);
        return parameters;
    }

}
