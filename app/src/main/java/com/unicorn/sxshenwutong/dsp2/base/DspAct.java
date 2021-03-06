package com.unicorn.sxshenwutong.dsp2.base;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.dsp2.base.entity.DspInfo;
import com.unicorn.sxshenwutong.dsp2.base.network.DspFetcher;
import com.unicorn.sxshenwutong.dsp2.base.network.DspSubmitter;
import com.unicorn.sxshenwutong.nextNode.NextNodeDialog;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindColor;
import butterknife.BindView;
import pocketknife.BindExtra;

abstract public class DspAct extends BaseAct {

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        fetchDspInfo();
    }

    // ===================== fetchDspInfo =====================

    @BindExtra(Key.AJBS)
    String ajbs;
    @BindExtra(Key.SPID)
    String spid;
    @BindExtra(Key.LCID)
    String lcid;

    private DspInfo dspInfo;

    private void fetchDspInfo() {
        new DspFetcher(ajbs, spid, lcid).start().subscribe(dspInfo -> {
            this.dspInfo = dspInfo;
            renderAjxx();
            renderSycxbg(dspInfo.getCxbgxx());
            renderFdsy(dspInfo.getYckcsxxx());
            renderWssp(dspInfo.getWslist());
            showSpyjList();
            clickSave();
        });
    }


    // =====================  =====================

    @BindView(R.id.tvSpyjLabel)
    TextView tvSpyjLabel;

    @BindView(R.id.etSpyj)
    protected EditText etSpyj;

    private void renderAjxx() {
        DspInfo.AjxxBean ajxx = dspInfo.getAjxx();
        setText(R.id.tvBt, bt(ajxx));
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, dspInfo.getAjxx().getSycxmc());

        setText(R.id.tvSqrq, dspInfo.getSpxx().getSqrq());
        tvSpyjLabel.setText(dspInfo.getDblbxx().getNodename());
    }

    abstract protected String bt(DspInfo.AjxxBean ajxx);

    protected void renderSycxbg(DspInfo.CxbgxxBean cxbgxx) {

    }

    protected void renderFdsy(DspInfo.YckcsxxxBean yckcsxxx) {

    }

    protected void renderWssp(List<DspInfo.WslistBean> wsList) {

    }

    // ===================== showSpyjList =====================

    @BindView(R.id.llSpyjContainer)
    LinearLayout llSpyjContainer;

    @BindColor(R.color.md_grey_100)
    int md_grey_100;

    private void showSpyjList() {
        for (DspInfo.SpyjlistBean spyj : dspInfo.getSpyjlist()) {
            showSpyj(spyj);
        }
    }

    private void showSpyj(DspInfo.SpyjlistBean spyj) {
        LinearLayout llSpyj = new LinearLayout(this);
        llSpyj.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams lpLabel = new LinearLayout.LayoutParams(ConvertUtils.dp2px(100), ViewGroup.LayoutParams.MATCH_PARENT);
        lpLabel.setMargins(0, 0, 1, 0);
        TextView tvLabel = new TextView(this);
        tvLabel.setBackgroundColor(md_grey_100);
        tvLabel.setGravity(Gravity.CENTER);
        tvLabel.setText(spyj.getNodename());
        tvLabel.setTextColor(Color.BLACK);
        llSpyj.addView(tvLabel, lpLabel);

        LinearLayout.LayoutParams lpSpyj = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        HtmlTextView tvSpyj = new HtmlTextView(this);
        tvSpyj.setBackgroundColor(Color.WHITE);
        tvSpyj.setGravity(Gravity.CENTER_VERTICAL);
        tvSpyj.setPadding(ConvertUtils.dp2px(16), 0, 0, 0);
        tvSpyj.setTextColor(Color.BLACK);
        tvSpyj.setHtml(spyj.getSpyj(), new HtmlResImageGetter(tvSpyj));
        llSpyj.addView(tvSpyj, lpSpyj);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 1, 0, 0);
        llSpyjContainer.addView(llSpyj, layoutParams);
    }


    // ===================== clickSave =====================

    private void clickSave() {
        RxView.clicks(findViewById(R.id.tvSave))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> showNextNodeDialog());
    }

    private void showNextNodeDialog() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put("currNodeid", dspInfo.getDblbxx().getNodeid());
        map.put("currNodeName", dspInfo.getDblbxx().getNodename());
        map.put("spyj", etSpyj.getText().toString().trim());
        NextNodeDialog nextNodeDialog = new NextNodeDialog(this, dspInfo.getDblbxx().getLcid(), new DspSubmitter(map), true);
        nextNodeDialog.setSqr(dspInfo.getSpxx().getSqr());
        nextNodeDialog.show();
    }

    @Override
    protected boolean useRxBus() {
        return true;
    }

}


