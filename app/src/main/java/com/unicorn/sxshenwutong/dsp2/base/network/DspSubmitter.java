package com.unicorn.sxshenwutong.dsp2.base.network;

import com.unicorn.sxshenwutong.unknown.SimpleSubmitter;

import java.util.HashMap;

public class DspSubmitter extends SimpleSubmitter {

    public DspSubmitter(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected String busiCode() {
        return "savesp";
    }

}
