package com.unicorn.sxshenwutong.a.network;

import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.network.entity.Params;

import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.UUID;

import javax.inject.Inject;

import cn.net.withub.common.util.sec.Md5Main;

@com.unicorn.sxshenwutong.a.dagger.App
public class ParamsInitializer {

    @Inject
    public ParamsInitializer() {
    }

    public void initParams(Params params, String busiCode, HashMap<String, Object> parameters) {
        params.setBusiCode(busiCode);
        params.setThirdFlow(UUID.randomUUID().toString());
        if (Global.getLoginResponse() != null) {
            params.setTicket(Global.getLoginResponse().getTicket());
        }
        params.setLoginName("");
        params.setRandCode(Md5Main.getRandom());
        params.setTime(new DateTime().toString(Key.DATE_VALUE_FORMAT));
        params.setSeqM("");
        String str = params.getUuid() + params.getBusiCode() + params.getThirdFlow() + params.getAppId() + params.getRandCode() + Params.md5key;
        try {
            params.setSecM(Md5Main.sign(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.setParameters(parameters);
    }

}
