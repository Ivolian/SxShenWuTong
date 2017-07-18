package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.d.SpdbSubmitter;

import java.util.HashMap;

public class SpdspSubmitter extends SpdbSubmitter {

    public SpdspSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "savesp";
    }

}
