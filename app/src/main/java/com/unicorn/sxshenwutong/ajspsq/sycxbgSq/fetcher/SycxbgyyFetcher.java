package com.unicorn.sxshenwutong.ajspsq.sycxbgSq.fetcher;

import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;

public class SycxbgyyFetcher extends CodeFetcher {

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


}
