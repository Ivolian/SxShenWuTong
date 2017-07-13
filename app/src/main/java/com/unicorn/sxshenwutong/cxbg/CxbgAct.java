package com.unicorn.sxshenwutong.cxbg;

import android.os.Bundle;
import android.widget.EditText;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jakewharton.rxbinding.view.RxView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.AjxxFetcher;
import com.unicorn.sxshenwutong.CxbglxFetcher;
import com.unicorn.sxshenwutong.NextNodeDialog;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.SycxbgyyFetcher;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.list.Ajxx;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import pocketknife.BindExtra;

import static com.unicorn.sxshenwutong.R.id.tvTitle;

public class CxbgAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_cxbg;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        clickSave();
        fetchAjxx();
    }

    private void clickSave() {
        RxView.clicks(findViewById(R.id.tvSave))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> showNextNodeDialog());
    }


    // ===================== fetchAjxx =====================

    @BindExtra(Key.AJBS)
    String ajbs;

    Ajxx ajxx;

    private void fetchAjxx() {
        new AjxxFetcher(ajbs, ajxx -> {
            this.ajxx = ajxx;
            renderAjxx();
            fetchCxbglx();
        }).start();
    }

    private void renderAjxx() {
        setText(tvTitle, ajxx.getAhqc() + "程序变更审批");
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvJarq, ajxx.getJarq());
        setText(R.id.tvLaay, ajxx.getLaaymc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, ajxx.getSycxmc());
    }


    // ===================== fetchCxbglx =====================

    List<Code> cxbglxList;

    private void fetchCxbglx() {
        new CxbglxFetcher(ajxx.getBzzh(), codeResponse -> {
            cxbglxList = codeResponse.getBmlist();
            msCxbglx.setItems(items(cxbglxList));
            fetchSycxbgyy(cxbglxList.get(0));
            msCxbglx.setOnItemSelectedListener((view, position, id, item) -> fetchSycxbgyy(cxbglxList.get(position)));
        }).start();
    }


    // ===================== fetchSycxbgyy =====================

    List<Code> sycxbgyyList;

    private void fetchSycxbgyy(Code cxbglx) {
        new SycxbgyyFetcher(ajxx, cxbglx, codeResponse -> {
            sycxbgyyList = codeResponse.getBmlist();
            msSycxbgyy.setItems(items(sycxbgyyList));
        }).start();
    }

    private List<String> items(List<Code> codeList) {
        List<String> list = new ArrayList<>();
        for (Code code : codeList) {
            list.add(code.getDmms());
        }
        return list;
    }


    // ===================== showNextNodeDialog =====================

    private void showNextNodeDialog() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        Code cxbglx = cxbglxList.get(msCxbglx.getSelectedIndex());
        map.put("cxbglx", cxbglx.getDm());
        map.put("cxbglxmc", cxbglx.getDmms());
        map.put("jyzptrq", new DateTime().toString("yyyyMMddHHmmss"));
        Code sycxbgyy = sycxbgyyList.get(msSycxbgyy.getSelectedIndex());
        map.put("sycxbgyy", sycxbgyy.getDm());
        map.put("sycxbgyymc", sycxbgyy.getDmms());
        map.put("bt", ajxx.getAhqc() + "程序变更审批");
        map.put("ngryj", etNgryj.getText().toString().trim());
        new NextNodeDialog(this, map,"CQ_DSP_SPGL_SP_AJJZPSP").show();
    }


    // ===================== onSubmitSuccess =====================

    @Override
    protected boolean useRxBus() {
        return true;
    }

    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }


    // ===================== views =====================

    @BindView(R.id.msCxbglx)
    MaterialSpinner msCxbglx;
    @BindView(R.id.msSycxbgyy)
    MaterialSpinner msSycxbgyy;
    @BindView(R.id.etNgryj)
    EditText etNgryj;

}
