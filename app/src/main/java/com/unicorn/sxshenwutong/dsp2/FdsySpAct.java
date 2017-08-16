package com.unicorn.sxshenwutong.dsp2;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.dsp2.base.DspAct;
import com.unicorn.sxshenwutong.dsp2.base.entity.DspInfo;

import java.util.Arrays;

import butterknife.BindView;


public class FdsySpAct extends DspAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_fdsy_sp;
    }

    @Override
    protected String bt(DspInfo.AjxxBean ajxx) {
        return ajxx.getAhqc() + "法定事由审批";
    }

    @Override
    protected void renderFdsy(DspInfo.YckcsxxxBean yckcsxxx) {
        setText(R.id.tvLxmc, yckcsxxx.getLxmc());
        setText(R.id.tvBglxmc, yckcsxxx.getBglxmc());
        setText(R.id.tvQsrq, yckcsxxx.getQsrq());
        setText(R.id.tvJsrq, yckcsxxx.getJsrq());
        setText(R.id.tvYcts, yckcsxxx.getYcts());
        setText(R.id.tvXh, yckcsxxx.getXh());
        setText(R.id.tvQtsm, yckcsxxx.getQtsm());
        copeBglxmc(yckcsxxx);
    }

    @BindView(R.id.llBglxmc)
    LinearLayout llBglxmc;
    @BindView(R.id.tvBglxmcLabel)
    TextView tvBglxmcLabel;
    @BindView(R.id.tvBglxmc)
    TextView tvBglxmc;

    private void copeBglxmc(DspInfo.YckcsxxxBean yckcsxxx) {
        if (Arrays.asList("延长", "扣除", "中止").contains(yckcsxxx.getLxmc())) {
            llBglxmc.setVisibility(View.VISIBLE);
            tvBglxmcLabel.setText(yckcsxxx.getLxmc());
            tvBglxmc.setText(yckcsxxx.getBglxmc());
        }
    }

    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }

}
