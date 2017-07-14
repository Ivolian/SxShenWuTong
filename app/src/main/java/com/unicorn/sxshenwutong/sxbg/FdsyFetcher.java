package com.unicorn.sxshenwutong.sxbg;

import com.unicorn.sxshenwutong.a.network.Callback;
import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;

public class FdsyFetcher extends CodeFetcher {

    public FdsyFetcher(Callback<CodeResponse> callback) {
        super("1049", callback);
    }

}
