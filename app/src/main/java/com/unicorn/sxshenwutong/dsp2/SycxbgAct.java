package com.unicorn.sxshenwutong.dsp2;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.dsp2.base.DspAct;
import com.unicorn.sxshenwutong.dsp2.base.entity.DspInfo;

public class SycxbgAct extends DspAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_spdsp_sycxbg;
    }

    @Override
    protected String bt(DspInfo.AjxxBean ajxx) {
        return ajxx.getAhqc() + "适用程序变更审批";
    }

    @Override
    protected void renderSycxbg(DspInfo.CxbgxxBean cxbgxx) {
        setText(R.id.tvCxbglx, cxbgxx.getCxbglxmc());
        setText(R.id.tvSycxbgyy, cxbgxx.getJyzptyymc());
    }

    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }

}
