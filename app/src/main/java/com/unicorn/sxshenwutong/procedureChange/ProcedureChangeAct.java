package com.unicorn.sxshenwutong.procedureChange;

import android.os.Bundle;
import android.widget.TextView;

import com.unicorn.sxshenwutong.AjxxFetcher;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.list.Ajxx;

import butterknife.BindView;
import pocketknife.BindExtra;

public class ProcedureChangeAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_procedure_change;
    }

    @BindExtra(Key.AJBS)
    String ajbs;

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        new AjxxFetcher(ajbs, this::renderAjxx).start();
    }

    private void renderAjxx(Ajxx ajxx) {
        tvTitle.setText(ajxx.getAhqc() + "适用程序变更审批");
        tvAhqc.setText(ajxx.getAhqc());
        tvLarq.setText(ajxx.getLarq());
        tvJarq.setText(ajxx.getJarq());
        tvLaay.setText(ajxx.getLaaymc());
        tvDyyg.setText(ajxx.getDyyg());
        tvDybg.setText(ajxx.getDybg());
        tvSycxmc.setText(ajxx.getSycxmc());
    }


    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvAhqc)
    TextView tvAhqc;
    @BindView(R.id.tvLarq)
    TextView tvLarq;
    @BindView(R.id.tvJarq)
    TextView tvJarq;
    @BindView(R.id.tvLaay)
    TextView tvLaay;
    @BindView(R.id.tvDyyg)
    TextView tvDyyg;
    @BindView(R.id.tvDybg)
    TextView tvDybg;
    @BindView(R.id.tvSycxmc)
    TextView tvSycxmc;

}
