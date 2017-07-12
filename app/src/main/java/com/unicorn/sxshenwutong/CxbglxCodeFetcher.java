package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;

import java.util.Map;

public class CxbglxCodeFetcher extends CodeFetcher {

    private String bzzh;

    public CxbglxCodeFetcher(String bzzh, Callback<CodeResponse> callback) {
        super(Key.CXBG_CODE, callback);
        this.bzzh = bzzh;
    }

    @Override
    protected Map<String, Object> parameters() {
        Map<String,Object> map =  super.parameters();
        map.put("bzzh",bzzh);
        return map;
    }
}
