package com.unicorn.sxshenwutong.base;

import com.unicorn.sxshenwutong.User;
import com.unicorn.sxshenwutong.code.Code;

import java.util.List;

public class Global {

    private static String ticket;
    private static List<Code> codes;
    private static User user;

    //

    public static String getTicket() {
        return ticket;
    }

    public static void setTicket(String ticket) {
        Global.ticket = ticket;
    }

    public static List<Code> getCodes() {
        return codes;
    }

    public static void setCodes(List<Code> codes) {
        Global.codes = codes;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Global.user = user;
    }
}
