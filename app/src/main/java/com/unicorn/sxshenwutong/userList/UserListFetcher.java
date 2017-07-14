package com.unicorn.sxshenwutong.userList;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.a.network.Callback;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.a.network.BaseFetcher;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

import java.util.HashMap;

import javax.inject.Inject;

public class UserListFetcher extends BaseFetcher<UserListResponse> {
    public UserListFetcher(Callback<UserListResponse> callback) {
        super(callback);
    }

    @Override
    public void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "GetUserList";
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("fydm", Global.getLoginResponse().getUser().getFydm());
        map.put("departid", Global.getLoginResponse().getUser().getDepart_id());
        return map;
    }

    @Inject
    Gson gson;

    @Override
    protected UserListResponse map(Response<LinkedTreeMap<String, String>> response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), UserListResponse.class);
    }

}
