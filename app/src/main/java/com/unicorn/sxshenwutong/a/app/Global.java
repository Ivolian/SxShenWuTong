package com.unicorn.sxshenwutong.a.app;

import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.b.login.entity.LoginResponse;
import com.unicorn.sxshenwutong.c.home.entity.HomeItem;

import java.util.List;

public class Global {

    private static LoginResponse loginResponse;
    private static List<Code> userTypeList;
    private static List<HomeItem> homeItemListTop;
    private static List<HomeItem> homeItemListBottom;

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

    public static List<HomeItem> getHomeItemListTop() {
        return homeItemListTop;
    }

    public static void setHomeItemListTop(List<HomeItem> homeItemListTop) {
        Global.homeItemListTop = homeItemListTop;
    }

    public static List<HomeItem> getHomeItemListBottom() {
        return homeItemListBottom;
    }

    public static void setHomeItemListBottom(List<HomeItem> homeItemListBottom) {
        Global.homeItemListBottom = homeItemListBottom;
    }

}
