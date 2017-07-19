package com.unicorn.sxshenwutong.d.spdsp.sp;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.d.spdsp.sp.base.SpdspAct;
import com.unicorn.sxshenwutong.d.spdsp.sp.entity.SpdspInfo;

import java.util.Arrays;

import butterknife.BindView;


public class FdsyAct extends SpdspAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_dpdsp_fdsy;
    }

    @Override
    protected String bt(SpdspInfo.AjxxBean ajxx) {
        return ajxx.getAhqc() + "法定事由审批";
    }

    @Override
    protected void renderFdsy(SpdspInfo.YckcsxxxBean yckcsxxx) {
        setText(R.id.tvLxmc, yckcsxxx.getLxmc());
        setText(R.id.tvBglxmc, yckcsxxx.getBglxmc());
        setText(R.id.tvQsrq, yckcsxxx.getQsrq());
        setText(R.id.tvJsrq, yckcsxxx.getJsrq());
        setText(R.id.tvYcts, yckcsxxx.getYcts());
        setText(R.id.tvXh, yckcsxxx.getXh());
        setText(R.id.tvQtsm, yckcsxxx.getQtsm());
        codeBglxmc(yckcsxxx);
    }

    @BindView(R.id.llBglxmc)
    LinearLayout llBglxmc;
    @BindView(R.id.tvBglxmcLabel)
    TextView tvBglxmcLabel;
    @BindView(R.id.tvBglxmc)
    TextView tvBglxmc;

    private void codeBglxmc(SpdspInfo.YckcsxxxBean yckcsxxx) {
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
