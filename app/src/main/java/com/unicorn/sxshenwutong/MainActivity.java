package com.unicorn.sxshenwutong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.net.withub.common.util.sec.Md5Main;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        JodaTimeAndroid.init(this);
        s();
    }

    Params params = new Params();

    private void s() {
        t2();
        Retrofit retrofit = new RetrofitProvider().provide();
        BaseService baseService = retrofit.create(BaseService.class);
        baseService
                .test(new Gson().toJson(params))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("");
                    }

                    @Override
                    public void onNext(Object o) {
                        Logger.d("");
                    }
                });
    }

    private void t() {
        params.setBusiCode("getFyList");
//        params.setThirdFlow("1234567");
        params.setThirdFlow(UUID.randomUUID().toString());
//        params.setTicket("87e3bb0f-ad2d-4133-b304-24a8dd848b60");
        params.setLoginName("");
//        params.setRandCode("123");
        params.setRandCode(Md5Main.getRandom());//
params.setTime(new DateTime().toString("yyyyMMddHHmmss"));
//        params.setTime("20160518162233");
params.setSeqM("");
        String str = params.getUuid() + params.getBusiCode() + params.getThirdFlow() + params.getAppId() + params.getRandCode() + Params.md5key;
        String str2 = null;
        try {
            str2 = Md5Main.sign(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.setSecM(str2);
        params.setParameters(new HashMap<String,Object>());
    }

    private void t2() {
        params.setBusiCode("login");
//        params.setThirdFlow("1234567");
        params.setThirdFlow(UUID.randomUUID().toString());
//        params.setTicket("87e3bb0f-ad2d-4133-b304-24a8dd848b60");
        params.setLoginName("");
//        params.setRandCode("123");
        params.setRandCode(Md5Main.getRandom());//
        params.setTime(new DateTime().toString("yyyyMMddHHmmss"));
//        params.setTime("20160518162233");
        params.setSeqM("");
        String str = params.getUuid() + params.getBusiCode() + params.getThirdFlow() + params.getAppId() + params.getRandCode() + Params.md5key;
        String str2 = null;
        try {
            str2 = Md5Main.sign(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params.setSecM(str2);

        Map<String,Object> pMap = new HashMap<>();
        pMap.put("fydm","M00");
        pMap.put("loginname","审判管理员");
        pMap.put("password","67673305");

        params.setParameters(pMap);
    }
}
