package com.unicorn.sxshenwutong.a.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseFra extends SupportFragment {

    protected abstract int layoutResId();

    protected boolean useRxBus() {
        return false;
    }

    protected void inject() {
        // 依赖注入
    }

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(layoutResId(), container, false);
        ButterKnife.bind(this, rootView);
        inject();
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

    protected void setText(int textViewId, String text) {
        TextView textView = (TextView) rootView.findViewById(textViewId);
        textView.setText(text);
    }

}
