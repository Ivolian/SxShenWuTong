package com.unicorn.sxshenwutong.ajspsq.sycxbgSq;

import com.unicorn.sxshenwutong.unknown.SimpleSubmitter;

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
