package com.unicorn.sxshenwutong.app;

import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.app.Response;

public interface Callback {

    void onSuccess(Response<LinkedTreeMap<String, String>> response);

}
