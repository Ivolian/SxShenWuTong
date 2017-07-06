package com.unicorn.sxshenwutong.A.app;

import com.unicorn.sxshenwutong.A.code.entity.Code;
import com.unicorn.sxshenwutong.B.login.entity.LoginResponse;

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
