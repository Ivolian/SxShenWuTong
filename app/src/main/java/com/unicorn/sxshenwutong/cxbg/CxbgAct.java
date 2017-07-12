package com.unicorn.sxshenwutong.cxbg;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.AjxxFetcher;
import com.unicorn.sxshenwutong.CxbglxFetcher;
import com.unicorn.sxshenwutong.Dialog;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.SycxbgyyFetcher;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.list.Ajxx;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @BindView(R.id.msCxbglx)
    MaterialSpinner msCxbglx;
    @BindView(R.id.msSycxbgyy)
    MaterialSpinner msSycxbgyy;
    List<Code> codes;
    List<Code> codes2;

    private void renderAjxx(Ajxx ajxx) {
        tvTitle.setText(ajxx.getAhqc() + "程序变更审批");
        tvAhqc.setText(ajxx.getAhqc());
        tvLarq.setText(ajxx.getLarq());
        tvJarq.setText(ajxx.getJarq());
        tvLaay.setText(ajxx.getLaaymc());
        tvDyyg.setText(ajxx.getDyyg());
        tvDybg.setText(ajxx.getDybg());
        tvSycxmc.setText(ajxx.getSycxmc());

        new CxbglxFetcher(ajxx.getBzzh(), new Callback<CodeResponse>() {
            @Override
            public void onSuccess(CodeResponse codeResponse) {
                codes = codeResponse.getBmlist();
                List<String> list = new ArrayList<String>();
                for (Code code : codes) {
                    list.add(code.getDmms());
                }
                msCxbglx.setItems(list);
                msCxbglx.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                        Code code = codes.get(position);
                        new SycxbgyyFetcher(ajxx, code, new Callback<CodeResponse>() {
                            @Override
                            public void onSuccess(CodeResponse codeResponse) {
                                codes2 = codeResponse.getBmlist();
                                List<String> list = new ArrayList<String>();
                                for (Code code : codes2) {
                                    list.add(code.getDmms());
                                }
                                msSycxbgyy.setItems(list);
                            }
                        }).start();
                    }
                });
            }
        }).start();


        RxView.clicks(findViewById(R.id.tvSave))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> showDialog());
    }

    private void showDialog() {
        Map<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        Code cxbglx = codes.get(msCxbglx.getSelectedIndex());
        map.put("cxbglx", cxbglx.getDm());
        map.put("cxbglxmc", cxbglx.getDmms());
        map.put("jyzptrq", new DateTime().toString("yyyyMMddHHmmss"));
        Code sycxbgyy = codes2.get(msSycxbgyy.getSelectedIndex());
        map.put("sycxbgyy", sycxbgyy.getDm());
        map.put("sycxbgyymc", sycxbgyy.getDmms());
        map.put("bt", tvTitle.getText());
        map.put("ngryj", etNgryj.getText());
        new Dialog().show(this, map);
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
    @BindView(R.id.etNgryj)
    EditText etNgryj;
}
