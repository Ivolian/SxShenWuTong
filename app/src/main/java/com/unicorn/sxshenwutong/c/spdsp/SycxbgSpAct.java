package com.unicorn.sxshenwutong.c.spdsp;

import android.os.Bundle;

import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;

import java.util.HashMap;

import pocketknife.BindExtra;

public class SycxbgSpAct extends BaseAct{

    @BindExtra(Key.AJBS)
    String ajbs;
    @BindExtra(Key.SPID)
    String spid;
    @BindExtra(Key.LCID)
    String lcid;

    //


    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        HashMap<String,Object> map =new HashMap<>();
        map.put(Key.AJBS,ajbs);
        map.put(Key.SPID,spid);
        map.put(Key.LCID,lcid);

        new SpFetcher(map).start().subscribe(o -> {

        });
    }
}
