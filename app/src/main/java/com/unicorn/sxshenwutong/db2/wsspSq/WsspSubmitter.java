package com.unicorn.sxshenwutong.db2.wsspSq;

import com.unicorn.sxshenwutong.unknown.SimpleSubmitter;

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
