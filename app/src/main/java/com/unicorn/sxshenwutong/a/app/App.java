package com.unicorn.sxshenwutong.a.app;

import android.app.Application;
import android.os.Environment;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.Utils;
import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.tinypinyin.lexicons.android.cncity.CnCityDict;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;

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
        Pinyin.init(Pinyin.newConfig().with(CnCityDict.getInstance(this)));
        AppComponentProvider.init(this);
    }

    public static String baseDir() {
        String dirPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + "/SXSHENWUTONG";
        FileUtils.createOrExistsDir(dirPath);
        return dirPath;
    }

    public static String baseUrl() {
        return "http://1.85.16.50:8081/ydba/";
    }

}