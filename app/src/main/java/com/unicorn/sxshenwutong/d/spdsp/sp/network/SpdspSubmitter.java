package com.unicorn.sxshenwutong.d.spdsp.sp.network;

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
