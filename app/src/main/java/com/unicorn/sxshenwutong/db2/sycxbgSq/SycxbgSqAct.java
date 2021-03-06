package com.unicorn.sxshenwutong.db2.sycxbgSq;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;
import com.unicorn.sxshenwutong.db2.base.DbSqAct;
import com.unicorn.sxshenwutong.db2.sycxbgSq.fetcher.CxbglxFetcher;
import com.unicorn.sxshenwutong.db2.sycxbgSq.fetcher.SycxbgyyFetcher;
import com.unicorn.sxshenwutong.nextNode.NextNodeDialog;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

import static com.unicorn.sxshenwutong.R.id.tvTitle;

public class SycxbgSqAct extends DbSqAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_sycxbg_sq;
    }

    @Override
    protected void afterFetchAjxx() {
        setText(tvTitle,  bt(ajxx));
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvJarq, ajxx.getJarq());
        setText(R.id.tvLaay, ajxx.getLaaymc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, ajxx.getSycxmc());
        fetchCxbglx();
    }


    // ===================== fetchCxbglx =====================

    List<Code> cxbglxList;

    private void fetchCxbglx() {
        new CxbglxFetcher(ajxx.getBzzh()).start().subscribe(new Subscriber<CodeResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CodeResponse codeResponse) {
                cxbglxList = codeResponse.getBmlist();
                msCxbglx.setItems(items(cxbglxList));
                fetchSycxbgyy(cxbglxList.get(0));
                msCxbglx.setOnItemSelectedListener((view, position, id, item) -> fetchSycxbgyy(cxbglxList.get(position)));
            }
        });
    }


    // ===================== fetchSycxbgyy =====================

    List<Code> sycxbgyyList;

    private void fetchSycxbgyy(Code cxbglx) {
        new SycxbgyyFetcher(ajxx, cxbglx).start().subscribe(new Subscriber<CodeResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CodeResponse codeResponse) {
                sycxbgyyList = codeResponse.getBmlist();
                msSycxbgyy.setItems(items(sycxbgyyList));
            }
        });
    }

    private List<String> items(List<Code> codeList) {
        List<String> list = new ArrayList<>();
        for (Code code : codeList) {
            list.add(code.getDmms());
        }
        return list;
    }


    // ===================== showNextNodeDialog =====================

    @Override
    protected void showNextNodeDialog() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        Code cxbglx = cxbglxList.get(msCxbglx.getSelectedIndex());
        map.put("cxbglx", cxbglx.getDm());
        map.put("cxbglxmc", cxbglx.getDmms());
        Code sycxbgyy = sycxbgyyList.get(msSycxbgyy.getSelectedIndex());
        map.put("sycxbgyy", sycxbgyy.getDm());
        map.put("sycxbgyymc", sycxbgyy.getDmms());
        map.put("jyzptrq", new DateTime().toString(Key.DATE_VALUE_FORMAT2));
        map.put("bt", bt(ajxx));
        map.put("ngryj", etNgryj.getText().toString().trim());
        NextNodeDialog nextNodeDialog =new NextNodeDialog(this, "CQ_DSP_SPGL_SP_AJJZPSP",new SycxbgSubmitter(map));
        nextNodeDialog.setSqr(Global.getLoginResponse().getUser().getId());
        nextNodeDialog.show();
    }

    private String bt(Ajxx ajxx) {
        return ajxx.getAhqc() + "适用程序变更申请";
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


}
