package com.unicorn.sxshenwutong.code;

public class Code {

    private String dm;
    private String dmms;

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

    public boolean equals(Code code) {
        return this.dm.equals(code.dm);
    }

}