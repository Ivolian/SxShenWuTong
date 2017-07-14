package com.unicorn.sxshenwutong.a.app;

import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.b.login.entity.LoginResponse;

import java.util.List;

public class Global {

    private static LoginResponse loginResponse;
    private static List<Code> userTypeList;

    //

    public static LoginResponse getLoginResponse() {
        return loginResponse;
    }

    public static void setLoginResponse(LoginResponse loginResponse) {
        Global.loginResponse = loginResponse;
    }

    public static List<Code> getUserTypeList() {
        return userTypeList;
    }

    public static void setUserTypeList(List<Code> userTypeList) {
        Global.userTypeList = userTypeList;
    }

}
