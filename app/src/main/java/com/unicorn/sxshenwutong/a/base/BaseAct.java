package com.unicorn.sxshenwutong.a.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import pocketknife.PocketKnife;

public abstract class BaseAct extends SupportActivity {

    final private int NO_LAYOUT = -1;

    protected int layoutResId() {
        return NO_LAYOUT;
    }

    protected boolean useRxBus() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (layoutResId() != NO_LAYOUT) {
            setContentView(layoutResId());
        }
        ButterKnife.bind(this);
        PocketKnife.bindExtras(this);
        inject();
        if (useRxBus()) {
            RxBus.get().register(this);
        }
        init(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (useRxBus()) {
            RxBus.get().unregister(this);
        }
        super.onDestroy();
    }

    protected void inject() {
        // 依赖注入
    }

    protected void init(Bundle savedInstanceState) {
        // 初始化工作
    }

    protected void clickBack() {
        RxView.clicks(findViewById(R.id.back))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> finish());
    }

    protected void setText(int textViewId, String text) {
        TextView textView = (TextView) findViewById(textViewId);
        textView.setText(text);
    }

}
