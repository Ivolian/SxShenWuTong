package com.unicorn.sxshenwutong.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

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
        inject();
//        if (useRxBus()) {
//            RxBus.get().register(this);
//        }
        init(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
//        if (useRxBus()) {
//            RxBus.get().unregister(this);
//        }
        super.onDestroy();
    }

    protected void inject() {
        // 依赖注入
    }

    protected void init(Bundle savedInstanceState) {
        // 初始化工作
    }

    protected void clicksBack() {
//        RxView.clicks(findViewById(R.id.back))
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .subscribe(aVoid -> finish());
    }

}
