package com.unicorn.sxshenwutong.d.spdsp.SxbgSp;

import android.os.Bundle;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.SpdspSubmitter;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.d.nextNode.NextNodeDialog;
import com.unicorn.sxshenwutong.d.spdsp.Spdsp;
import com.unicorn.sxshenwutong.d.spdsp.SpdspFetcher;

import java.util.HashMap;

import pocketknife.BindExtra;

public class SxbgSpAct extends BaseAct {

    @BindExtra(Key.AJBS)
    String ajbs;
    @BindExtra(Key.SPID)
    String spid;
    @BindExtra(Key.LCID)
    String lcid;

    //


    @Override
    protected int layoutResId() {
        return R.layout.act_sxbg_sp;
    }

    private Spdsp spdsp;

    @Override
    protected void init(Bundle savedInstanceState) {
        fetchSpdsp();
    }

    private void fetchSpdsp() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put(Key.LCID, lcid);

        new SpdspFetcher(map).start().subscribe(o -> {
            spdsp = o;
            submit();
        });
    }

    private void renderSpdsp() {

    }


    private void submit() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put("currNodeid", spdsp.getDblbxx().getNodeid());
        map.put("currNodeName", spdsp.getDblbxx().getNodename());
        map.put("spyj", "通过");
        map.put("nextParamsVal", "commitToContinue");

        new NextNodeDialog(this, spdsp.getDblbxx().getLcid(), new SpdspSubmitter(map)).show();
    }

}
