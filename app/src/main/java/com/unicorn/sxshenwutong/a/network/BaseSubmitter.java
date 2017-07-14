package com.unicorn.sxshenwutong.a.network;

import com.unicorn.sxshenwutong.a.network.Callback;
import com.unicorn.sxshenwutong.a.network.BaseFetcher;

abstract public class BaseSubmitter<T> extends BaseFetcher<T> {

    public BaseSubmitter(Callback<T> callback) {
        super(callback);
    }
}
