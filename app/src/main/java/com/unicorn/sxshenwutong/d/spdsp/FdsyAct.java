package com.unicorn.sxshenwutong.d.spdsp;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;

public class FdsyAct extends SpdspAct {
    @Override
    protected void afterFetchSpdsp() {
        renderSpdsp();
    }

    @Override
    protected int layoutResId() {
        return R.layout.act_dpdsp_fdsy;
    }

    private void renderSpdsp() {
        Spdsp.AjxxBean ajxx = spdsp.getAjxx();
        setText(R.id.tvBt, ajxx.getAhqc() + "法定事由审批");
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, spdsp.getAjxx().getSycxmc());

        setText(R.id.tvSqrq, spdsp.getSpxx().getSqrq());
        setText(R.id.tvLxmc,spdsp.getYckcsxxx().getLxmc());
        setText(R.id.tvBglxmc,spdsp.getYckcsxxx().getBglxmc());

        setText(R.id.tvQsrq,spdsp.getYckcsxxx().getQsrq());
        setText(R.id.tvJsrq,spdsp.getYckcsxxx().getJsrq());
        setText(R.id.tvYcts,spdsp.getYckcsxxx().getYcts());
        setText(R.id.tvXh,spdsp.getYckcsxxx().getXh());
        setText(R.id.tvQtsm,spdsp.getYckcsxxx().getQtsm());
    }

    // 这个不能放基类里
    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }


}
