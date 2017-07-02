package com.unicorn.sxshenwutong.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseFra extends SupportFragment {

    protected abstract int layoutResId();

    protected boolean useRxBus() {
        return false;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(layoutResId(), container, false);
        ButterKnife.bind(this, rootView);
        init(rootView);
        if (useRxBus()) {
            RxBus.get().register(this);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (useRxBus()) {
            RxBus.get().register(this);
        }
    }

    protected void init(View rootView) {

    }

}
