package com.unicorn.sxshenwutong.d.spdsp;

import android.os.Bundle;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
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
    protected int layoutResId() {
        return R.layout.act_sycxbg_sp;
    }

    SpdspFull spdspFull;
    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        HashMap<String,Object> map =new HashMap<>();
        map.put(Key.AJBS,ajbs);
        map.put(Key.SPID,spid);
        map.put(Key.LCID,lcid);

        new SpFetcher(map).start().subscribe(o -> {
            spdspFull = o;
            submit();
        });
    }



    private void submit(){
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put("currNodeid",spdspFull.getDblbxx().getNodeid());
        map.put("currNodeName",spdspFull.getDblbxx().getNodename());
        map.put("spyj","通过");
        map.put("nextParamsVal","commitToContinue");

//        new NextNodeDialog(this, map,spdspFull.getDblbxx().getLcid()).show();
    }

}
