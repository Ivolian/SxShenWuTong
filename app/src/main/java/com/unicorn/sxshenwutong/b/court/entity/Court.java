package com.unicorn.sxshenwutong.b.court.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import me.yokeyword.indexablerv.IndexableEntity;

@Entity
public class Court implements IndexableEntity{

    @Id
    private String dm;
    private String dmms;
    private String fyjc;
    private String pinyin;

    @Generated(hash = 566614311)
    public Court(String dm, String dmms, String fyjc, String pinyin) {
        this.dm = dm;
        this.dmms = dmms;
        this.fyjc = fyjc;
        this.pinyin = pinyin;
    }

    @Generated(hash = 382166988)
    public Court() {
    }

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
