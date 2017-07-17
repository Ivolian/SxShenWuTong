package com.unicorn.sxshenwutong.d.spdb.sxbgSq;

import com.unicorn.sxshenwutong.d.SpdbSubmitter;

import java.util.HashMap;

public class SxbgSubmitter extends SpdbSubmitter {

    public SxbgSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "saveSxbgsq";
    }

}
