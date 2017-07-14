package com.unicorn.sxshenwutong.userList;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

import javax.inject.Inject;

public class UserListFetcher extends BaseFetcher<UserListResponse> {

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
    protected UserListResponse map(Response response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), UserListResponse.class);
    }

}
