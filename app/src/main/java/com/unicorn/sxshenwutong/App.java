package com.unicorn.sxshenwutong;

import android.app.Application;
import android.os.Environment;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;

import net.danlew.android.joda.JodaTimeAndroid;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        JodaTimeAndroid.init(this);
        AppComponentProvider.init(this);
//        initFragmentation();
    }

    //
//    private void initFragmentation() {
//        Fragmentation.builder()
//                .stackViewMode(Fragmentation.BUBBLE)
//                .debug(BuildConfig.DEBUG)
//                .install();
//    }
//


    public static String baseDir() {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + "/SXSHENWUTONG";
        FileUtils.createOrExistsDir(path);
        return path;
    }


}