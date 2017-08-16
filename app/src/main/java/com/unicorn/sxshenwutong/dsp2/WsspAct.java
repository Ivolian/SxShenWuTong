package com.unicorn.sxshenwutong.dsp2;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.dsp2.base.DspAct;
import com.unicorn.sxshenwutong.dsp2.base.entity.DspInfo;

import java.util.List;

public class WsspAct extends DspAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_spdsp_wssp;
    }

    @Override
    protected String bt(DspInfo.AjxxBean ajxx) {
        return ajxx.getAhqc() + "文书审批";
    }

    @Override
    protected void renderWssp(List<DspInfo.WslistBean> wsList) {
        setText(R.id.tvSpws,wsList.get(0).getXsmc());
    }
    
    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }

}
