package com.unicorn.sxshenwutong.dsp2.network;

import com.unicorn.sxshenwutong.unknown.SimpleSubmitter;

import java.util.HashMap;

public class SpdspSubmitter extends SimpleSubmitter {

    public SpdspSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "savesp";
    }

}
