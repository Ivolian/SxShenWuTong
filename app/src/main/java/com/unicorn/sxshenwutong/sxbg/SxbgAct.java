package com.unicorn.sxshenwutong.sxbg;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate;
import com.appeaser.sublimepickerlibrary.recurrencepicker.SublimeRecurrencePicker;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jakewharton.rxbinding.view.RxView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.AjxxFetcher;
import com.unicorn.sxshenwutong.NextNodeDialog;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.date.DateUtil;
import com.unicorn.sxshenwutong.date.SublimePickerFragment;
import com.unicorn.sxshenwutong.list.Ajxx;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import pocketknife.BindExtra;


public class SxbgAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_sxbg;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        clickSave();
        clickDate();
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
            fetchFdsy();


        }).start();

        // ===================== date =====================


    }

    private void clickDate() {
        onDateChange(tvStartDate, startDate);
        onDateChange(tvEndDate, endDate);
        RxView.clicks(tvStartDate)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> DateUtil.show(startDate, getSupportFragmentManager(), new SublimePickerFragment.Callback() {
                    @Override
                    public void onCancelled() {

                    }

                    @Override
                    public void onDateTimeRecurrenceSet(SelectedDate selectedDate, int hourOfDay, int minute, SublimeRecurrencePicker.RecurrenceOption recurrenceOption, String recurrenceRule) {
                        startDate = new DateTime(selectedDate.getFirstDate());
                        onDateChange(tvStartDate, startDate);
                    }
                }));
        RxView.clicks(tvEndDate)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> DateUtil.show(endDate, getSupportFragmentManager(), new SublimePickerFragment.Callback() {
                    @Override
                    public void onCancelled() {

                    }

                    @Override
                    public void onDateTimeRecurrenceSet(SelectedDate selectedDate, int hourOfDay, int minute, SublimeRecurrencePicker.RecurrenceOption recurrenceOption, String recurrenceRule) {
                        endDate = new DateTime(selectedDate.getFirstDate());
                        onDateChange(tvEndDate, endDate);
                    }
                }));
    }

    private String dateFormat = "yyyy年MM月dd日";
    private String dateValueFormat = "yyyy年MM月dd日";
    private DateTime startDate = new DateTime();
    private DateTime endDate = new DateTime();

    private void onDateChange(TextView tvDate, DateTime date) {
        tvDate.setText(date.toString(dateFormat));
    }


    private void renderAjxx() {
        setText(R.id.tvTitle, ajxx.getAhqc() + "程序变更审批");
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvJarq, ajxx.getJarq());
        setText(R.id.tvLaay, ajxx.getLaaymc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, ajxx.getSycxmc());
    }


    // ===================== fetchFdsy =====================

    List<Code> fdsyList;

    private void fetchFdsy() {
        new FdsyFetcher(codeResponse -> {
            fdsyList = codeResponse.getBmlist();
            msFdsy.setItems(items(fdsyList));
            fetchYckcyy(fdsyList.get(0));
            msFdsy.setOnItemSelectedListener((view, position, id, item) -> fetchYckcyy(fdsyList.get(position)));
        }).start();
    }


    // ===================== fetchYckcyy =====================

    List<Code> yckcyyList;

    private void fetchYckcyy(Code fdsy) {
        String fdsyMc = fdsy.getDmms();
        if (Arrays.asList("延长", "扣除", "中止").contains(fdsyMc)) {
            new YckcyyFetcher(fdsy, codeResponse -> {
                yckcyyList = codeResponse.getBmlist();
                msYckcyy.setItems(items(yckcyyList));

                tvYckcyy.setText(fdsyMc);
                llYckcyy.setVisibility(View.VISIBLE);
            }).start();
        } else {
            llYckcyy.setVisibility(View.GONE);
        }
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
        Code cxbglx = fdsyList.get(msFdsy.getSelectedIndex());
        map.put("cxbglx", cxbglx.getDm());
        map.put("cxbglxmc", cxbglx.getDmms());
        map.put("jyzptrq", new DateTime().toString("yyyyMMddHHmmss"));
        Code sycxbgyy = yckcyyList.get(msYckcyy.getSelectedIndex());
        map.put("sycxbgyy", sycxbgyy.getDm());
        map.put("sycxbgyymc", sycxbgyy.getDmms());
        map.put("bt", ajxx.getAhqc() + "程序变更审批");
        map.put("ngryj", etNgryj.getText().toString().trim());
        new NextNodeDialog(this, map).show();
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

    @BindView(R.id.msFdsy)
    MaterialSpinner msFdsy;
    @BindView(R.id.llYckcyy)
    LinearLayout llYckcyy;
    @BindView(R.id.tvYckcyy)
    TextView tvYckcyy;
    @BindView(R.id.msYckcyy)
    MaterialSpinner msYckcyy;
    @BindView(R.id.tvStartDate)
    TextView tvStartDate;
    @BindView(R.id.tvEndDate)
    TextView tvEndDate;
    @BindView(R.id.etQtsm)
    EditText etQtsm;
    @BindView(R.id.etNgryj)
    EditText etNgryj;

}
