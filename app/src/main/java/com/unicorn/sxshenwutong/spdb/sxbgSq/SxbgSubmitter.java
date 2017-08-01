package com.unicorn.sxshenwutong.spdb.sxbgSq;

import com.unicorn.sxshenwutong.f.SimpleSubmitter;

import java.util.HashMap;

public class SxbgSubmitter extends SimpleSubmitter {

    public SxbgSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "saveSxbgsq";
    }

}
