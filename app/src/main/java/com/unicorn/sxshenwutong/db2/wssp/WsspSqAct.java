package com.unicorn.sxshenwutong.db2.wssp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.db.ajws.select.AjwsSelectListAct;
import com.unicorn.sxshenwutong.db.ajws.base.entity.Ajws;
import com.unicorn.sxshenwutong.d.nextNode.NextNodeDialog;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;
import com.unicorn.sxshenwutong.db2.AjxxFetcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import pocketknife.BindExtra;
import rx.Subscriber;

import static com.unicorn.sxshenwutong.R.id.tvTitle;

public class WsspSqAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_wssp_sq;
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
        new AjxxFetcher(ajbs).start().subscribe(new Subscriber<Ajxx>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Ajxx ajxx) {
                WsspSqAct.this.ajxx = ajxx;
                renderAjxx();
            }
        });

        new WsspLcidFetcher(ajbs).start().subscribe(new Subscriber<LcidResponse>() {
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


         tvSpws.setOnClickListener(v -> {
             Intent intent = new Intent(WsspSqAct.this, AjwsSelectListAct.class);
             intent.putExtra(Key.TITLE, "选择案件文书");
             intent.putExtra(Key.LBTYPE, "ajwslist");
             intent.putExtra(Key.AJBS, ajbs);
             startActivity(intent);
         });
    }

    LcidResponse lcidResponse;

    private void renderAjxx() {
        setText(tvTitle, bt(ajxx));
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvLaay, ajxx.getLaaymc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
    }

    // ===================== showNextNodeDialog =====================


    private void showNextNodeDialog() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);

//        map.put("jyzptrq", new DateTime().toString(Key.DATE_VALUE_FORMAT2));
        map.put("bt", bt(ajxx));
        map.put("ngryj", etNgryj.getText().toString().trim());
        map.put("lcid", lcidResponse.getLcid());
        map.put("lcmc", lcidResponse.getLcmc());

        String ids = "";
        for (Ajws ajws:ajwsList) {
            ids += (ajws.getJlid() + ",");
        }
        ids = ids.substring(0,ids.length()-1);
        map.put("wsjlids",ids);


        // todo
        NextNodeDialog nextNodeDialog = new NextNodeDialog(this, lcidResponse.getLcid(), new WsspSubmitter(map));
        nextNodeDialog.setSqr(Global.getLoginResponse().getUser().getId());
        nextNodeDialog.show();
    }

    private String bt(Ajxx ajxx) {
        return ajxx.getAhqc() + "文书审批申请";
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

    List<Ajws> ajwsList;
    @Subscribe(tags = {@Tag(RxBusTag.SELECT_AJWS)})
    public void onAjwsSelect(ArrayList<Ajws> ajwsList){
        String text = "";
        for (Ajws ajws:ajwsList){
            text +=  ajws.getXsmc();
        }
        tvSpws.setText(text);
        this.ajwsList = ajwsList;
    }


    // ===================== views =====================

    @BindView(R.id.tvSpws)
    TextView tvSpws;
    @BindView(R.id.etNgryj)
    EditText etNgryj;

}
