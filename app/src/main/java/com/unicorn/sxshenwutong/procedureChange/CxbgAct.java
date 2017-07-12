package com.unicorn.sxshenwutong.procedureChange;

import android.os.Bundle;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.AjxxFetcher;
import com.unicorn.sxshenwutong.CxbgCodeFetcher;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.list.Ajxx;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pocketknife.BindExtra;

public class CxbgAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_cxbg;
    }

    @BindExtra(Key.AJBS)
    String ajbs;

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        new AjxxFetcher(ajbs, this::renderAjxx).start();


    }

    @BindView(R.id.nsCxbglx)
    MaterialSpinner nsCxbglx;

    private void renderAjxx(Ajxx ajxx) {
        tvTitle.setText(ajxx.getAhqc() + "适用程序变更审批");
        tvAhqc.setText(ajxx.getAhqc());
        tvLarq.setText(ajxx.getLarq());
        tvJarq.setText(ajxx.getJarq());
        tvLaay.setText(ajxx.getLaaymc());
        tvDyyg.setText(ajxx.getDyyg());
        tvDybg.setText(ajxx.getDybg());
        tvSycxmc.setText(ajxx.getSycxmc());

        new CxbgCodeFetcher(ajxx.getBzzh(), new Callback<CodeResponse>() {
            @Override
            public void onSuccess(CodeResponse codeResponse) {
                List<Code> codes = codeResponse.getBmlist();
                List<String> list = new ArrayList<String>();
                for (Code code:codes){
                    list.add(code.getDmms());
                }
                nsCxbglx.setItems("Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow");

//                nsCxbglx.attachDataSource(list);
            }
        }).start();
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
