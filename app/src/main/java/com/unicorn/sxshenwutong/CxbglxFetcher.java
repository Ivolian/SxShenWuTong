package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;

import java.util.HashMap;

public class CxbglxFetcher extends CodeFetcher {

    private String bzzh;

    public CxbglxFetcher(String bzzh, Callback<CodeResponse> callback) {
        super(Key.CXBG_CODE, callback);
        this.bzzh = bzzh;
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String,Object> map =  super.parameters();
        map.put("bzzh",bzzh);
        return map;
    }
}
