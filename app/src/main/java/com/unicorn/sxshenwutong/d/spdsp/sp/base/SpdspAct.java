package com.unicorn.sxshenwutong.d.spdsp.sp.base;

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
import com.unicorn.sxshenwutong.SpdspSubmitter;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.d.nextNode.NextNodeDialog;
import com.unicorn.sxshenwutong.d.spdsp.sp.entity.SpdspInfo;
import com.unicorn.sxshenwutong.d.spdsp.sp.fetcher.SpdspFetcher;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import butterknife.BindColor;
import butterknife.BindView;
import pocketknife.BindExtra;

abstract public class SpdspAct extends BaseAct {

    @BindExtra(Key.AJBS)
    String ajbs;
    @BindExtra(Key.SPID)
    String spid;
    @BindExtra(Key.LCID)
    String lcid;

    protected SpdspInfo spdspInfo;

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        fetchSpdsp();
    }

    private void clickSave() {
        RxView.clicks(findViewById(R.id.tvSave))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> showNextNodeDialog());
    }

    protected void renderFdsy(SpdspInfo.YckcsxxxBean yckcsxxx){

    }

    protected void renderSycxbg(SpdspInfo.CxbgxxBean cxbgxx){

    }

    private void showNextNodeDialog() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put("currNodeid", spdspInfo.getDblbxx().getNodeid());
        map.put("currNodeName", spdspInfo.getDblbxx().getNodename());
        map.put("spyj", etSpyj.getText().toString().trim());
        new NextNodeDialog(this, spdspInfo.getDblbxx().getLcid(), new SpdspSubmitter(map), true).show();
    }

    abstract protected String bt(SpdspInfo.AjxxBean ajxx);

    private void fetchSpdsp() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put(Key.LCID, lcid);
        new SpdspFetcher(map).start().subscribe(o -> {
            spdspInfo = o;
            s();
            t();
        renderSpdsp();

            clickSave();
            renderFdsy(spdspInfo.getYckcsxxx());
            renderSycxbg(spdspInfo.getCxbgxx());
        });
    }

    private void renderSpdsp() {
        SpdspInfo.AjxxBean ajxx = spdspInfo.getAjxx();
        setText(R.id.tvBt, bt(ajxx));
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, spdspInfo.getAjxx().getSycxmc());
        setText(R.id.tvSqrq, spdspInfo.getSpxx().getSqrq());

    }


    @BindView(R.id.tvSpyjLabel)
    TextView tvSpyjLabel;

    @BindView(R.id.etSpyj)
    protected EditText etSpyj;

    private void t(){
        SpdspInfo.DblbxxBean dblbxxBean = spdspInfo.getDblbxx();
        tvSpyjLabel.setText(dblbxxBean.getNodename());
    }


    @BindView(R.id.llSpyjContainer)
    LinearLayout llSpyjContainer;



    @BindColor(R.color.md_grey_100)
    int md_grey_100;


    private void s(){
        for(SpdspInfo.SpyjlistBean spyj: spdspInfo.getSpyjlist()){
            addSpyj(spyj);
        }
    }



    private void addSpyj(SpdspInfo.SpyjlistBean spyj){
        LinearLayout linearLayout =new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams lpLabel = new LinearLayout.LayoutParams(ConvertUtils.dp2px(100), ViewGroup.LayoutParams.MATCH_PARENT);
        lpLabel.setMargins(0,0,1,0);
        TextView tvLabel  = new TextView(this);
        tvLabel.setBackgroundColor(md_grey_100);
        tvLabel.setGravity(Gravity.CENTER);
        tvLabel.setText(spyj.getNodename());
        tvLabel.setTextColor(Color.BLACK);
        linearLayout.addView(tvLabel,lpLabel);

        LinearLayout.LayoutParams lpSpyj = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
        HtmlTextView tvSpyj  = new HtmlTextView(this);
        tvSpyj.setBackgroundColor(Color.WHITE);
        tvSpyj.setGravity(Gravity.CENTER_VERTICAL);
        tvSpyj.setPadding(ConvertUtils.dp2px(16),0,0,0);
        tvSpyj.setTextColor(Color.BLACK);
        tvSpyj.setHtml(spyj.getSpyj(), new HtmlResImageGetter(tvSpyj));
        linearLayout.addView(tvSpyj,lpSpyj);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,1,0,0);
        llSpyjContainer.addView(linearLayout,layoutParams);
    }


    // ===================== onSubmitSuccess =====================

    @Override
    protected boolean useRxBus() {
        return true;
    }


}


