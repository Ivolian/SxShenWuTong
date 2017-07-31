package com.unicorn.sxshenwutong.d.spdb.wssp;

import com.unicorn.sxshenwutong.f.SimpleSubmitter;

import java.util.HashMap;

public class WsspSubmitter extends SimpleSubmitter {

    public WsspSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "saveWssp";
    }

}
