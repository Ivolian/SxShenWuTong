package com.unicorn.sxshenwutong.d.ajcl;

import com.unicorn.sxshenwutong.a.dagger.App;
import com.unicorn.sxshenwutong.a.network.ParamsInitializer;
import com.unicorn.sxshenwutong.a.network.entity.Params;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.File;
import java.util.HashMap;

import javax.inject.Inject;

@App
public class UploadHelper {

    private ParamsInitializer paramsInitializer;

    @Inject
    public UploadHelper(ParamsInitializer paramsInitializer) {
        this.paramsInitializer = paramsInitializer;
    }

    public void upload(HashMap<String, Object> map, String filePath, Callback callback) {
        Params params = new Params();
        paramsInitializer.initParams(params, "fileUpload", map);
        String url = com.unicorn.sxshenwutong.a.app.App.baseUrl() + "request.shtml?params=" + params;
        File file = new File(filePath);
        OkHttpUtils.post()
                .addFile("files", file.getName(), file)
                .url(url)
                .build()
                .execute(callback);
    }

}
