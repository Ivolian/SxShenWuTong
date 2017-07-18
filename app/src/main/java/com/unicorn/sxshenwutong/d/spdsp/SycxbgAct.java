package com.unicorn.sxshenwutong.d.spdsp;

import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.SpdspSubmitter;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.d.nextNode.NextNodeDialog;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SycxbgAct extends SpdspAct {

    @Override
    protected void afterFetchSpdsp() {
        renderSpdsp();
clickSave();
    }


    //


    @Override
    protected int layoutResId() {
        return R.layout.act_spdsp_sycxbg;
    }


    private void renderSpdsp() {
        Spdsp.AjxxBean ajxx = spdsp.getAjxx();
        setText(R.id.tvBt, ajxx.getAhqc() + "法定事由审批");
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvSqrq, ajxx.getLarq());
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, ajxx.getSycxmc());

        setText(R.id.tvSqrq, spdsp.getSpxx().getSqrq());
        setText(R.id.tvCxbglx, spdsp.getCxbgxx().getCxbglxmc());
        setText(R.id.tvSycxbgyy, spdsp.getCxbgxx().getJyzptyymc());


    }


    private void clickSave() {
        RxView.clicks(findViewById(R.id.tvSave))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> showNextNodeDialog());
    }


    private void showNextNodeDialog() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put("currNodeid", spdsp.getDblbxx().getNodeid());
        map.put("currNodeName", spdsp.getDblbxx().getNodename());
        map.put("spyj", etSpyj.getText().toString().trim());
        map.put("nextParamsVal", "commitToContinue");
        new NextNodeDialog(this, spdsp.getDblbxx().getLcid(), new SpdspSubmitter(map)).show();
    }

}
