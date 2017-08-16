package com.unicorn.sxshenwutong.db2.fdsySq.fetcher;

import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.a.code.entity.Code;

import java.util.HashMap;

public class YckcyyFetcher extends CodeFetcher {

    private Code fdsy;

    public YckcyyFetcher(Code fdsy) {
        super("");
        this.fdsy = fdsy;
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("parentid", fdsy.getDm());
        return parameters;
    }

}
