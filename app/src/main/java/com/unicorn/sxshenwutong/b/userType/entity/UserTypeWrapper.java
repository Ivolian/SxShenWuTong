package com.unicorn.sxshenwutong.b.userType.entity;

import com.unicorn.sxshenwutong.a.code.entity.Code;

public class UserTypeWrapper {

    private Code code;
    private boolean checked;

    //

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
