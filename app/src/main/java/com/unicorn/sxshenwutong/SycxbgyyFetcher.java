package com.unicorn.sxshenwutong;

import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.list.Ajxx;

public class SycxbgyyFetcher extends CodeFetcher {

    private String bzzh;

    public SycxbgyyFetcher(Ajxx ajxx, Code cxbglx) {
        super(bxh(ajxx, cxbglx));
    }

    private static String bxh(Ajxx ajxx, Code cxbglx) {
        switch (ajxx.getAjlb()) {
            case "1":
                return "32003";
            case "2":
                switch (cxbglx.getDm()) {
                    case "20001":
                        return "32001";
                    case "10202":
                        return "32002";
                    default:
                        return "32001";
                }
            case "6":
            case "7":
                return "32004";
            default:
                return "";
        }
    }

//    @Override
//    protected Map<String, Object> parameters() {
//        Map<String, Object> map = super.parameters();
//        map.put("bzzh", bzzh);
//        return map;
//    }
}
