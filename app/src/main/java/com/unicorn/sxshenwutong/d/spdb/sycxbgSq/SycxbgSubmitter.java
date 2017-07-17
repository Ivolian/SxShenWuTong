package com.unicorn.sxshenwutong.d.spdb.sycxbgSq;

import com.unicorn.sxshenwutong.d.SpdbSubmitter;

import java.util.HashMap;

public class SycxbgSubmitter extends SpdbSubmitter {

    public SycxbgSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "saveJzpsq";
    }

}
