package com.unicorn.sxshenwutong.base;

import com.unicorn.sxshenwutong.User;
import com.unicorn.sxshenwutong.userType.UserType;

import java.util.List;

public class Global {

    private static String ticket;
    private static User user;
    private static List<UserType> userTypes;

    //

    public static String getTicket() {
        return ticket;
    }

    public static void setTicket(String ticket) {
        Global.ticket = ticket;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Global.user = user;
    }

    public static List<UserType> getUserTypes() {
        return userTypes;
    }

    public static void setUserTypes(List<UserType> userTypes) {
        Global.userTypes = userTypes;
    }


}
