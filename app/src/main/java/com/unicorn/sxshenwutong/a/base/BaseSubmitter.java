package com.unicorn.sxshenwutong.a.base;

import com.unicorn.sxshenwutong.a.app.Callback;

abstract public class BaseSubmitter<T> extends BaseFetcher<T> {

    public BaseSubmitter(Callback<T> callback) {
        super(callback);
    }
}
