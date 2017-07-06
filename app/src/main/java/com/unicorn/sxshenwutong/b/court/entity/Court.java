package com.unicorn.sxshenwutong.b.court.entity;

import me.yokeyword.indexablerv.IndexableEntity;

public class Court implements IndexableEntity{

    private String dm;
    private String dmms;
    private String fyjc;
    private String pinyin;

    //

    public String getFyjc() {
        return fyjc;
    }

    public void setFyjc(String fyjc) {
        this.fyjc = fyjc;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    public String getDmms() {
        return dmms;
    }

    public void setDmms(String dmms) {
        this.dmms = dmms;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    //

    @Override
    public String getFieldIndexBy() {
        return pinyin;
    }

    @Override
    public void setFieldIndexBy(String s) {

    }

    @Override
    public void setFieldPinyinIndexBy(String s) {

    }

}
