package com.unicorn.sxshenwutong.d.ajcl;

import android.content.Context;

import com.example.mylibrary.http.MyHttpCliet;
import com.example.mylibrary.http.MyHttpDataHelp;
import com.example.mylibrary.http.UploadDownloadlistener;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.dagger.App;
import com.unicorn.sxshenwutong.a.network.ParamsInitializer;
import com.unicorn.sxshenwutong.a.network.entity.Params;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.File;
import java.util.HashMap;

import javax.inject.Inject;

@App
public class PostHelper {

    private void start(Context activity, HashMap<String, Object> map, String filePath, UploadDownloadlistener uploadDownloadlistener) {
        MyHttpDataHelp.ticket = Global.getLoginResponse().getTicket();
        String url = MyHttpDataHelp.Assemblyurl(activity, "http://1.85.16.50:8081/ydba/request.shtml", "fileUpload", map);
        File file = new File(filePath);
        new MyHttpCliet(activity).uploadFile(url, file, uploadDownloadlistener);
    }

    private ParamsInitializer paramsInitializer;

    @Inject
    public PostHelper(ParamsInitializer paramsInitializer) {
        this.paramsInitializer = paramsInitializer;
    }

    public void start2(HashMap<String, Object> map, String filePath, Callback callback) {
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
