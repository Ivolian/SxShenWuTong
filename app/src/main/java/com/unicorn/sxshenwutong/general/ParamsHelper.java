package com.unicorn.sxshenwutong.general;

import com.unicorn.sxshenwutong.base.Global;

import org.joda.time.DateTime;

import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import cn.net.withub.common.util.sec.Md5Main;

@com.unicorn.sxshenwutong.dagger.App
public class ParamsHelper {

    @Inject
    public ParamsHelper() {
    }

    public void initParams(Params params, String busiCode, Map<String, Object> parameters) {
        params.setBusiCode(busiCode);
        params.setThirdFlow(UUID.randomUUID().toString());
        if (Global.getTicket() != null) {
            params.setTicket(Global.getTicket());
        }
        params.setLoginName("");
        params.setRandCode(Md5Main.getRandom());
        params.setTime(new DateTime().toString("yyyyMMddHHmmss"));
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
