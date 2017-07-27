package com.unicorn.sxshenwutong.d.ajcl;

import android.content.Context;

import com.example.mylibrary.http.MyHttpCliet;
import com.example.mylibrary.http.MyHttpDataHelp;
import com.example.mylibrary.http.UploadDownloadlistener;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.a.app.Global;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.HashMap;

import okhttp3.Call;

public class PostHelper {

    public void start(Context activity, HashMap<String, Object> map, String filePath, UploadDownloadlistener uploadDownloadlistener) {
        MyHttpDataHelp.ticket = Global.getLoginResponse().getTicket();
        String url = MyHttpDataHelp.Assemblyurl(activity, "http://1.85.16.50:8081/ydba/request.shtml", "fileUpload", map);
        File file = new File(filePath);
        new MyHttpCliet(activity).uploadFile(url, file, uploadDownloadlistener);
    }

    public void start2(Context activity, HashMap<String, Object> map, String filePath, UploadDownloadlistener uploadDownloadlistener) {
        MyHttpDataHelp.ticket = Global.getLoginResponse().getTicket();
        String url = MyHttpDataHelp.Assemblyurl(activity, "http://1.85.16.50:8081/ydba/request.shtml", "fileUpload", map);
        File file = new File(filePath);

        OkHttpUtils.post()//
                .addFile("files", file.getName(), file)//
                .url(url)

                .build()//
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.d("");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.d("");
                    }
                });

    }

}
