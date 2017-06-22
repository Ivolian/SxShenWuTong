package com.unicorn.sxshenwutong;

import java.util.HashMap;
import java.util.Map;

public class Params {

    private String uuid = "58e01a1c-56e6-42f2-8725-563dca4b3898";
    private String version = "1.0";
    // 请求业务
    private String busiCode;
    private String loginName;
    private String appId = "04e8310b-86f0-478c-b102-76f3c0710c00";
    // 64位以内流水号每次访问是唯一的
    private String thirdFlow;
    // 登陆后的返回值用来获取其它参数
    private String ticket;
    // 随机数
    private String randCode;
    // 时间
    private String time;
 private String seqM;
    // md5加密后的字符串
    private String secM;
    // md5密钥
    public static String md5key = "b6474df096ac3750";
    private Map<String,Object> parameters =new HashMap<String, Object>();
    //

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getThirdFlow() {
        return thirdFlow;
    }

    public void setThirdFlow(String thirdFlow) {
        this.thirdFlow = thirdFlow;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getRandCode() {
        return randCode;
    }

    public void setRandCode(String randCode) {
        this.randCode = randCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeqM() {
        return seqM;
    }

    public void setSeqM(String seqM) {
        this.seqM = seqM;
    }

    public String getSecM() {
        return secM;
    }

    public void setSecM(String secM) {
        this.secM = secM;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
