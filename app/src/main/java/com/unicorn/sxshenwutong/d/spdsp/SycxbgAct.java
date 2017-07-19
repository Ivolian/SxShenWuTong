package com.unicorn.sxshenwutong.d.spdsp;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;

public class SycxbgAct extends SpdspAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_spdsp_sycxbg;
    }

    @Override
    protected void afterFetchSpdsp() {
        renderSpdsp();

    }

    private void renderSpdsp() {
        Spdsp.AjxxBean ajxx = spdsp.getAjxx();
        setText(R.id.tvBt, ajxx.getAhqc() + "适用程序变更审批");
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, ajxx.getSycxmc());

        setText(R.id.tvSqrq, spdsp.getSpxx().getSqrq());
        setText(R.id.tvCxbglx, spdsp.getCxbgxx().getCxbglxmc());
        setText(R.id.tvSycxbgyy, spdsp.getCxbgxx().getJyzptyymc());
    }

    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }



}
