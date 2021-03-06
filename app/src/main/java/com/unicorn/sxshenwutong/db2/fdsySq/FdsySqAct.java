package com.unicorn.sxshenwutong.db2.fdsySq;

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
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;
import com.unicorn.sxshenwutong.db2.base.DbSqAct;
import com.unicorn.sxshenwutong.db2.fdsySq.fetcher.FdsyFetcher;
import com.unicorn.sxshenwutong.db2.fdsySq.fetcher.YckcyyFetcher;
import com.unicorn.sxshenwutong.nextNode.NextNodeDialog;
import com.unicorn.sxshenwutong.other.date.DateUtil;
import com.unicorn.sxshenwutong.other.date.SublimePickerFragment;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Subscriber;


public class FdsySqAct extends DbSqAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_fdsy_sq;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clickDate();
    }

    private DateTime startDate = new DateTime();
    private DateTime endDate = new DateTime();

    private void onDateChange(TextView tvDate, DateTime date) {
        tvDate.setText(date.toString("yyyy年MM月dd日"));
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

    @Override
    protected void afterFetchAjxx() {
        setText(R.id.tvTitle, bt(ajxx));
        setText(R.id.tvAhqc, ajxx.getAhqc());
        setText(R.id.tvLarq, ajxx.getLarq());
        setText(R.id.tvJarq, ajxx.getJarq());
        setText(R.id.tvLaay, ajxx.getLaaymc());
        setText(R.id.tvDyyg, ajxx.getDyyg());
        setText(R.id.tvDybg, ajxx.getDybg());
        setText(R.id.tvSycxmc, ajxx.getSycxmc());
        fetchFdsy();
    }


    // ===================== fetchFdsy =====================

    List<Code> fdsyList;

    private void fetchFdsy() {
        new FdsyFetcher().start().subscribe(new Subscriber<CodeResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CodeResponse codeResponse) {
                fdsyList = codeResponse.getBmlist();
                msFdsy.setItems(items(fdsyList));
                fetchYckcyy(fdsyList.get(0));
                msFdsy.setOnItemSelectedListener((view, position, id, item) -> fetchYckcyy(fdsyList.get(position)));

//                ArrayAdapter adapter = new ArrayAdapter<String >(FdsySqAct.this,android.R.layout.simple_list_item_1,items(fdsyList));
//
//
//                //第四步：将适配器添加到下拉列表上
//                niceSpinner.setAdapter(adapter);
            }
        });
    }



    // ===================== fetchYckcyy =====================

    List<Code> yckcyyList;

    private void fetchYckcyy(Code fdsy) {
        String fdsyMc = fdsy.getDmms();
        if (Arrays.asList("延长", "扣除", "中止").contains(fdsyMc)) {
            new YckcyyFetcher(fdsy).start().subscribe(new Subscriber<CodeResponse>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(CodeResponse codeResponse) {
                    yckcyyList = codeResponse.getBmlist();
                    msYckcyy.setItems(items(yckcyyList));
                    tvYckcyy.setText(fdsyMc);
                    llYckcyy.setVisibility(View.VISIBLE);
                }
            });
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

    @Override
    protected void showNextNodeDialog() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.FYDM, Global.getLoginResponse().getUser().getFydm());
        map.put(Key.AJBS, ajbs);
        Code fdsy = fdsyList.get(msFdsy.getSelectedIndex());
        map.put("lx", fdsy.getDm());
        map.put("lxmc", fdsy.getDmms());
        String fdsyMc = fdsy.getDmms();
        if (Arrays.asList("延长", "扣除", "中止").contains(fdsyMc)) {
            Code yckcyy = yckcyyList.get(msYckcyy.getSelectedIndex());
            map.put("bglx", yckcyy.getDm());
            map.put("bglxmc", yckcyy.getDmms());
        }
        map.put("bt", bt(ajxx));
        map.put("ngryj", etNgryj.getText().toString().trim());
        map.put("qsrq", startDate.toString(Key.DATE_VALUE_FORMAT2));
        map.put("jsrq", endDate.toString(Key.DATE_VALUE_FORMAT2));
        map.put("qtsm", etQtsm.getText().toString().trim());
        Period period = new Period(startDate, endDate, PeriodType.days());
        int days = period.getDays();
        map.put("ts", days);
        NextNodeDialog nextNodeDialog = new NextNodeDialog(this, "CQ_DSP_SPGL_SP_FDSYSP", new FdsySubmitter(map));
        nextNodeDialog.setSqr(Global.getLoginResponse().getUser().getId());
        nextNodeDialog.show();
    }

    private String bt(Ajxx ajxx) {
        return ajxx.getAhqc() + "法定事由申请";
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

}
