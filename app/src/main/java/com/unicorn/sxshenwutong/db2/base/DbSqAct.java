package com.unicorn.sxshenwutong.db2.base;

import android.os.Bundle;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.db.db.entity.Ajxx;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import pocketknife.BindExtra;
import rx.Subscriber;

public abstract class DbSqAct extends BaseAct {

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

    @BindExtra(Key.AJBS)
    public String ajbs;

    protected Ajxx ajxx;

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
                DbSqAct.this.ajxx = ajxx;
                afterFetchAjxx();
            }
        });


    }

    abstract protected void afterFetchAjxx();

    abstract protected void showNextNodeDialog();

    @BindView(R.id.etNgryj)
    protected EditText etNgryj;

}