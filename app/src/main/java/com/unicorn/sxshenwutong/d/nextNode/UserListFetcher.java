package com.unicorn.sxshenwutong.d.nextNode;

import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;

import java.util.HashMap;

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

    @Override
    protected UserListResponse map(Response response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), UserListResponse.class);
    }

}
