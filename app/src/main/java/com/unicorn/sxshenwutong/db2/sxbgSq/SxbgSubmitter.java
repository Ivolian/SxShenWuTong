package com.unicorn.sxshenwutong.db2.sxbgSq;

import com.unicorn.sxshenwutong.unknown.SimpleSubmitter;

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
