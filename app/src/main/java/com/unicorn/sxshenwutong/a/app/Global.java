package com.unicorn.sxshenwutong.a.app;

import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.b.login.entity.LoginResponse;

import java.util.List;

public class Global {

    private static LoginResponse loginResponse;
    private static List<Code> userTypeCodes;

    //

    public static LoginResponse getLoginResponse() {
        return loginResponse;
    }

    public static void setLoginResponse(LoginResponse loginResponse) {
        Global.loginResponse = loginResponse;
    }

    public static List<Code> getUserTypeCodes() {
        return userTypeCodes;
    }

    public static void setUserTypeCodes(List<Code> userTypeCodes) {
        Global.userTypeCodes = userTypeCodes;
    }

}
