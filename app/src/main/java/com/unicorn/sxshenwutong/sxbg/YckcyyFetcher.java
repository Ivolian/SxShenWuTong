package com.unicorn.sxshenwutong.sxbg;

import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;

import java.util.HashMap;

public class YckcyyFetcher extends CodeFetcher {

    private Code fdsy;

    public YckcyyFetcher(Code fdsy, Callback<CodeResponse> callback) {
        super("", callback);
        this.fdsy = fdsy;
    }

    @Override
    protected HashMap<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("parentid", fdsy.getDm());
        return parameters;
    }

}
