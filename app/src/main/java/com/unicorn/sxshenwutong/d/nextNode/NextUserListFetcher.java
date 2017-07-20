package com.unicorn.sxshenwutong.d.nextNode;

import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.a.network.base.BaseFetcher;
import com.unicorn.sxshenwutong.a.network.entity.Response;
import com.unicorn.sxshenwutong.d.nextNode.entity.NextUserListResponse;

import java.util.HashMap;

public class NextUserListFetcher extends BaseFetcher<NextUserListResponse> {

    private String lcid;
    private String spjdid;  //审批节点id
    private String sqrid;   //申请人id

    public NextUserListFetcher(String lcid, String spjdid, String sqrid) {
        this.lcid = lcid;
        this.spjdid = spjdid;
        this.sqrid = sqrid;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected String busiCode() {
        return "getNextUserList";
    }

    @Override
    protected NextUserListResponse map(Response response) {
        return gson.fromJson(response.getParameters().get(Key.YDBAKEY), NextUserListResponse.class);
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.LCID, lcid);
        map.put(Key.SPJDID, spjdid);
        map.put("sqrid", sqrid);
        return map;
    }

}
