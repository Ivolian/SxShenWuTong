package com.unicorn.sxshenwutong.db2.wssp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.db.ajws.base.entity.Ajws;
import com.unicorn.sxshenwutong.db.ajws.select.AjwsSelectListAct;
import com.unicorn.sxshenwutong.db2.base.DbSqAct;
import com.unicorn.sxshenwutong.db2.wssp.lcid.LcidFetcher;
import com.unicorn.sxshenwutong.db2.wssp.lcid.LcidResponse;
import com.unicorn.sxshenwutong.nextNode.NextNodeDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Subscriber;

import static com.unicorn.sxshenwutong.R.id.tvTitle;

public class WsspSqAct extends DbSqAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_wssp_sq;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clickSpws();
        fetchWsspLcid();
    }

    @Override
    protected void afterFetchAjxx() {
        setText(tvTitle, ajxx.getAhqc() + "文书审批申请");
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvLaay, ajxx.getLaaymc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
    }

    private void clickSpws() {
        RxView.clicks(tvSpws)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    Intent intent = new Intent(WsspSqAct.this, AjwsSelectListAct.class);
                    intent.putExtra(Key.TITLE, "选择案件文书");
                    intent.putExtra(Key.LBTYPE, "ajwslist");
                    intent.putExtra(Key.AJBS, ajbs);
                    startActivity(intent);
                });
    }

    private LcidResponse lcidResponse;

    private void fetchWsspLcid() {
        new LcidFetcher(ajbs).start().subscribe(new Subscriber<LcidResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LcidResponse lcidResponse) {
                WsspSqAct.this.lcidResponse = lcidResponse;
            }
        });
    }


    @Override
    protected void showNextNodeDialog() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        map.put("bt", ajxx.getAhqc() + "文书审批申请");
        map.put("ngryj", etNgryj.getText().toString().trim());
        map.put("lcid", lcidResponse.getLcid());
        map.put("lcmc", lcidResponse.getLcmc());
        String wsjlids = "";
        for (Ajws ajws : ajwsList) {
            wsjlids += (ajws.getJlid() + ",");
        }
        wsjlids = wsjlids.substring(0, wsjlids.length() - 1);
        map.put("wsjlids", wsjlids);
        NextNodeDialog nextNodeDialog = new NextNodeDialog(this, lcidResponse.getLcid(), new WsspSubmitter(map));
        nextNodeDialog.setSqr(Global.getLoginResponse().getUser().getId());
        nextNodeDialog.show();
    }


    @Override
    protected boolean useRxBus() {
        return true;
    }

    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }


    private List<Ajws> ajwsList;

    @BindView(R.id.tvSpws)
    TextView tvSpws;

    @Subscribe(tags = {@Tag(RxBusTag.SELECT_AJWS)})
    public void onAjwsSelect(ArrayList<Ajws> ajwsList) {
        String text = "";
        for (Ajws ajws : ajwsList) {
            text += (ajws.getXsmc() + "\r\n");
        }
        tvSpws.setText(text);
        this.ajwsList = ajwsList;
    }


}
