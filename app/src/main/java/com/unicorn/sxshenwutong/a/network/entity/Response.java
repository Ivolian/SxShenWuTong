package com.unicorn.sxshenwutong.a.network.entity;

import com.google.gson.internal.LinkedTreeMap;

public class Response {

    /**
     * code : 000000
     * msg : 请求成功
     * busiCode : getFyList
     * randCode : 92cfb7f8-5c05-42d5-9247-36a67829d5a3
     * time : 20170622141844
     * seqM :
     * secM :
     * seqD :
     * seqR :
     * thirdFlow : 1234567
     */

    private String code;
    private String msg;
    private String busiCode;
    private String randCode;
    private String time;
    private String seqM;
    private String secM;
    private String seqD;
    private String seqR;
    private String thirdFlow;
    private LinkedTreeMap<String, String> parameters;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
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

    public String getSeqD() {
        return seqD;
    }

    public void setSeqD(String seqD) {
        this.seqD = seqD;
    }

    public String getSeqR() {
        return seqR;
    }

    public void setSeqR(String seqR) {
        this.seqR = seqR;
    }

    public String getThirdFlow() {
        return thirdFlow;
    }

    public void setThirdFlow(String thirdFlow) {
        this.thirdFlow = thirdFlow;
    }

    public LinkedTreeMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(LinkedTreeMap<String, String> parameters) {
        this.parameters = parameters;
    }

}

