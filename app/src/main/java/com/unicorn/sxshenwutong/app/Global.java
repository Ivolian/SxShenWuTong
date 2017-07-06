package com.unicorn.sxshenwutong.app;

import com.unicorn.sxshenwutong.login.data.LoginResponse;
import com.unicorn.sxshenwutong.userType.UserType;

import java.util.List;

public class Global {

    private static LoginResponse loginResponse;
    private static List<UserType> userTypes;

    //

    public static LoginResponse getLoginResponse() {
        return loginResponse;
    }

    public static void setLoginResponse(LoginResponse loginResponse) {
        Global.loginResponse = loginResponse;
    }

    public static List<UserType> getUserTypes() {
        return userTypes;
    }

    public static void setUserTypes(List<UserType> userTypes) {
        Global.userTypes = userTypes;
    }


}
