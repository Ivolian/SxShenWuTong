package com.unicorn.sxshenwutong.d.spdsp;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.d.spdsp.sp.base.SpdspAct;
import com.unicorn.sxshenwutong.d.spdsp.sp.entity.SpdspInfo;

import java.util.List;

public class WsspAct extends SpdspAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_spdsp_wssp;
    }

    @Override
    protected String bt(SpdspInfo.AjxxBean ajxx) {
        return ajxx.getAhqc() + "文书审批";
    }

    @Override
    protected void renderWssp(List<SpdspInfo.WslistBean> wsList) {
        setText(R.id.tvSpws,wsList.get(0).getXsmc());
    }
    
    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }

}
