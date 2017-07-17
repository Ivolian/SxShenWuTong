package com.unicorn.sxshenwutong.d.spdb.sycxbgSq.fetcher;

import com.unicorn.sxshenwutong.a.code.CodeFetcher;

import java.util.HashMap;

public class CxbglxFetcher extends CodeFetcher {

    private String bzzh;

    public CxbglxFetcher(String bzzh) {
        super("900002");
        this.bzzh = bzzh;
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> map = super.parameters();
        map.put("bzzh", bzzh);
        return map;
    }

}
