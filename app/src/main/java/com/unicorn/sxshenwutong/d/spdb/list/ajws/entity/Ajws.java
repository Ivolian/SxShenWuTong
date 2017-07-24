package com.unicorn.sxshenwutong.d.spdb.list.ajws.entity;

import com.unicorn.sxshenwutong.a.app.App;

import java.io.File;

public class Ajws {

    /**
     * cjsj : 2017-05-17 14:59:19.0
     * stbh :
     * wjlj : /ws/M00/fgsws/2017/5_17/M00_ace389a3-0403-4e90-9bad-a379b8127b42.doc
     * ajbs : 1b7d32a6-9d5a-4c13-9540-f09e72dce919
     * xsmc : 申请宣告死亡2（因意外事故下落不明，经有关机关证明该公民不可能生存）
     * cjr : 审判管理员
     * zjxgr : 审判管理员
     * zjxgsj : 2017-05-17 15:04:13.0
     * jlid : M0034a6d009-f087-4449-86f6-03884ad4fc29
     * fydm : M00
     */

    public String getName() {
        int index = wjlj.lastIndexOf("/");
        String re = wjlj.substring(index + 1);
        return re;
    }

    public String getPath() {
        return App.baseDir() + "/" + getName();
    }

    public File getFile() {
        return new File(getPath());
    }

    public boolean exists() {
        return getFile().exists();
    }

    private String cjsj;
    private String stbh;
    private String wjlj;
    private String ajbs;
    private String xsmc;
    private String cjr;
    private String zjxgr;
    private String zjxgsj;
    private String jlid;
    private String fydm;

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getStbh() {
        return stbh;
    }

    public void setStbh(String stbh) {
        this.stbh = stbh;
    }

    public String getWjlj() {
        return wjlj;
    }

    public void setWjlj(String wjlj) {
        this.wjlj = wjlj;
    }

    public String getAjbs() {
        return ajbs;
    }

    public void setAjbs(String ajbs) {
        this.ajbs = ajbs;
    }

    public String getXsmc() {
        return xsmc;
    }

    public void setXsmc(String xsmc) {
        this.xsmc = xsmc;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr;
    }

    public String getZjxgr() {
        return zjxgr;
    }

    public void setZjxgr(String zjxgr) {
        this.zjxgr = zjxgr;
    }

    public String getZjxgsj() {
        return zjxgsj;
    }

    public void setZjxgsj(String zjxgsj) {
        this.zjxgsj = zjxgsj;
    }

    public String getJlid() {
        return jlid;
    }

    public void setJlid(String jlid) {
        this.jlid = jlid;
    }

    public String getFydm() {
        return fydm;
    }

    public void setFydm(String fydm) {
        this.fydm = fydm;
    }

}
