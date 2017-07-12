package com.unicorn.sxshenwutong.procedureChange;

import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.AjxxFetcher;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;

import pocketknife.BindExtra;

public class ProcedureChangeAct  extends BaseAct{

    @Override
    protected int layoutResId() {
        return super.layoutResId();
    }

    @BindExtra(Key.AJBS)
    String ajbs;

    @Override
    protected void init(Bundle savedInstanceState) {
        new AjxxFetcher(ajbs, new Callback() {
            @Override
            public void onSuccess(String ydbaKey) {
                Logger.d(ydbaKey);
            }
        }).start();
    }


}
