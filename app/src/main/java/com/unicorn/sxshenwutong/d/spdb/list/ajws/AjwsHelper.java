package com.unicorn.sxshenwutong.d.spdb.list.ajws;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.d.spdb.list.ajws.entity.Ajws;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

public class AjwsHelper {

    private Activity activity;
    private Ajws ajws;

    public AjwsHelper(Activity activity, Ajws ajws) {
        this.activity = activity;
        this.ajws = ajws;
    }

    public void viewAjws() {
        if (ajws.exists()) {
            open();
        } else {
            download();
        }
    }

    private void open() {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        String type = getMIMEType(ajws.getName());
//        Uri apkUri = FileProvider.getUriForFile(activity, "com.unicorn.sxshenwutong.fileprovider", ajws.getFile());
        intent.setDataAndType(Uri.fromFile(ajws.getFile()), type);
        activity.startActivity(intent);
    }

    private void download() {
        String url = App.baseUrl() + ajws.getWjlj();
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new FileCallBack(App.baseDir(), ajws.getName()) {
                    @Override
                    public void onResponse(File response, int id) {
                        FileUtils.createOrExistsFile(response);
                        open();
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.d(e);
                        ToastUtils.showShort("文件不存在");
                    }
                });
    }


    private static final String[][] MIME_MapTable = {
            //{后缀名，MIME类型}
            {".3gp", "video/3gpp"},
            {".apk", "application/vnd.android.package-archive"},
            {".asf", "video/x-ms-asf"},
            {".avi", "video/x-msvideo"},
            {".bin", "application/octet-stream"},
            {".bmp", "image/bmp"},
            {".c", "text/plain"},
            {".class", "application/octet-stream"},
            {".conf", "text/plain"},
            {".cpp", "text/plain"},
            {".doc", "application/msword"},
            {".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.ajws"},
            {".xls", "application/vnd.ms-excel"},
            {".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
            {".exe", "application/octet-stream"},
            {".gif", "image/gif"},
            {".gtar", "application/x-gtar"},
            {".gz", "application/x-gzip"},
            {".h", "text/plain"},
            {".htm", "text/html"},
            {".html", "text/html"},
            {".jar", "application/java-archive"},
            {".java", "text/plain"},
            {".jpeg", "image/jpeg"},
            {".jpg", "image/jpeg"},
            {".js", "application/x-javascript"},
            {".log", "text/plain"},
            {".m3u", "audio/x-mpegurl"},
            {".m4a", "audio/mp4a-latm"},
            {".m4b", "audio/mp4a-latm"},
            {".m4p", "audio/mp4a-latm"},
            {".m4u", "video/vnd.mpegurl"},
            {".m4v", "video/x-m4v"},
            {".mov", "video/quicktime"},
            {".mp2", "audio/x-mpeg"},
            {".mp3", "audio/x-mpeg"},
            {".mp4", "video/mp4"},
            {".mpc", "application/vnd.mpohun.certificate"},
            {".mpe", "video/mpeg"},
            {".mpeg", "video/mpeg"},
            {".mpg", "video/mpeg"},
            {".mpg4", "video/mp4"},
            {".mpga", "audio/mpeg"},
            {".msg", "application/vnd.ms-outlook"},
            {".ogg", "audio/ogg"},
            {".pdf", "application/pdf"},
            {".png", "image/png"},
            {".pps", "application/vnd.ms-powerpoint"},
            {".ppt", "application/vnd.ms-powerpoint"},
            {".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"},
            {".prop", "text/plain"},
            {".rc", "text/plain"},
            {".rmvb", "audio/x-pn-realaudio"},
            {".rtf", "application/rtf"},
            {".sh", "text/plain"},
            {".tar", "application/x-tar"},
            {".tgz", "application/x-compressed"},
            {".txt", "text/plain"},
            {".wav", "audio/x-wav"},
            {".wma", "audio/x-ms-wma"},
            {".wmv", "audio/x-ms-wmv"},
            {".wps", "application/vnd.ms-works"},
            {".xml", "text/plain"},
            {".z", "application/x-compress"},
            {".zip", "application/x-zip-compressed"},
            {"", "*/*"}
    };

    private String getMIMEType(String fileName) {
        String type = "*/*";
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex < 0) {
            return type;
        }

        String end = fileName.substring(dotIndex, fileName.length()).toLowerCase();  /* 获取文件的后缀名*/
        if (end.equals("")) return type;
        //在MIME和文件类型的匹配表中找到对应的MIME类型。
        for (int i = 0; i < MIME_MapTable.length; i++) {
            if (end.equals(MIME_MapTable[i][0]))
                type = MIME_MapTable[i][1];
        }
        return type;
    }

}
