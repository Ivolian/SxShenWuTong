package com.unicorn.sxshenwutong.db2.fdsySq;

import com.unicorn.sxshenwutong.unknown.SimpleSubmitter;

import java.util.HashMap;

public class FdsySubmitter extends SimpleSubmitter {

    public FdsySubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "saveSxbgsq";
    }

}
