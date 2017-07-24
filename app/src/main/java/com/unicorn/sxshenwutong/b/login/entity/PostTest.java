package com.unicorn.sxshenwutong.b.login.entity;

import android.content.Context;

import com.example.mylibrary.http.MyHttpCliet;
import com.example.mylibrary.http.MyHttpDataHelp;
import com.example.mylibrary.http.UploadDownloadlistener;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.network.ParamsInitializer;
import com.unicorn.sxshenwutong.a.network.entity.Params;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostTest {

    public void start2(Context activity, String ajbs) {
        MyHttpCliet myHttpCliet = new MyHttpCliet(activity);
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.AJBS, ajbs);
        map.put("title", "标题哦");
        map.put("bz", "描述哦");
        String url = MyHttpDataHelp.Assemblyurl(activity, "http://1.85.16.50:8081/ydba/request.shtml", "fileUpload", map);
        File file = new File(App.baseDir(), "1.pdf");
        myHttpCliet.uploadFile(url, file, new UploadDownloadlistener() {
            @Override
            public void onStartDownLoad() {
                Logger.e("");
            }

            @Override
            public void onCompleteRateChanged(int completeRate) {
                Logger.e("");
            }

            @Override
            public void onDownloadCompleted(String result) {
                Logger.e("");
                System.out.println("1111111111111111111111111111" + result);
            }
        });
    }

    public void start(Context activity, String ajbs) {
        ParamsInitializer paramsInitializer = new ParamsInitializer();
        Params params = new Params();
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.AJBS, ajbs);
        map.put("title", "标题哦");
        map.put("bz", "描述哦");
        paramsInitializer.initParams(params, "fileUpload", map);
        File file = new File(App.baseDir(), "1.pdf");
        String url2 = "http://1.85.16.50:8081/ydba/request.shtml?params=" + params.toString();


        MyHttpCliet myHttpCliet = new MyHttpCliet(activity);
//        File file = new File(bmxtDaglAjstws.getWjlj());
//        MyHttpDataHelp.ticket="8db566c9-8708-4c4a-8bcb-f84d2cb18687";
       String url = MyHttpDataHelp.Assemblyurl(activity, "http://1.85.16.50:8081/ydba/request.shtml", "fileUpload", map);
        myHttpCliet.uploadFile(url, file, new UploadDownloadlistener() {
            @Override
            public void onStartDownLoad() {
                Logger.e("");
            }

            @Override
            public void onCompleteRateChanged(int completeRate) {
                Logger.e("");
            }

            @Override
            public void onDownloadCompleted(String result) {
                Logger.e("");
                System.out.println("1111111111111111111111111111" + result);
            }
        });

        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        MultipartBody requestBody = (new okhttp3.MultipartBody.Builder()).setType(MultipartBody.FORM).addFormDataPart("files", file.getName(), fileBody).build();
        Request request = (new Request.Builder()).url(url2).post(requestBody).build();
        Call call = new OkHttpClient().newCall(request);
        call.enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                Logger.e("");
            }

            public void onResponse(Call call, Response response) throws IOException {
                Logger.e("");

            }
        });

        OkHttpUtils.post()

                .addFile(file.getName(),file.getName(), file)//
//                .addFile("mFile", "test1.txt", file2)//
                .url(url2)
//                .params(params)//
//                .headers(header
/// s)//
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.e("");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.e("");

                    }
                });
//        OkHttpUtils
//                .postFile()
//                .url(url)
//                .file(file)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Logger.d(e);
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        Logger.d(response);
//                    }
//                });
//    }
    }
}
