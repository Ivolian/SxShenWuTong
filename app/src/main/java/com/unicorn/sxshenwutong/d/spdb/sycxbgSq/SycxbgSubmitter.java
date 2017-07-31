package com.unicorn.sxshenwutong.d.spdb.sycxbgSq;

import com.unicorn.sxshenwutong.f.SimpleSubmitter;

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
