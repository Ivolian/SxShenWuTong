package com.unicorn.sxshenwutong.d.ajcl;

import android.content.Context;

import com.example.mylibrary.http.MyHttpCliet;
import com.example.mylibrary.http.MyHttpDataHelp;
import com.example.mylibrary.http.UploadDownloadlistener;
import com.unicorn.sxshenwutong.a.app.Global;

import java.io.File;
import java.util.HashMap;

public class PostHelper {

    public void start(Context activity, HashMap<String, Object> map, String filePath, UploadDownloadlistener uploadDownloadlistener) {
        MyHttpDataHelp.ticket = Global.getLoginResponse().getTicket();
        String url = MyHttpDataHelp.Assemblyurl(activity, "http://1.85.16.50:8081/ydba/request.shtml", "fileUpload", map);
        File file = new File(filePath);
        new MyHttpCliet(activity).uploadFile(url, file, uploadDownloadlistener);
    }

}
