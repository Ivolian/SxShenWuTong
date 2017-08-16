package com.unicorn.sxshenwutong.db2.sycxbgSq;

import com.unicorn.sxshenwutong.other.SimpleSubmitter;

import java.util.HashMap;

public class SycxbgSubmitter extends SimpleSubmitter {

    public SycxbgSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "saveJzpsq";
    }

}
