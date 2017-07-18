package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.d.SpdbSubmitter;

import java.util.HashMap;

public class SpSubmitter extends SpdbSubmitter {

    public SpSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "savesp";
    }

}
