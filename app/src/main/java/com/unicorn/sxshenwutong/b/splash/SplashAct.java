package com.unicorn.sxshenwutong.b.splash;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import com.github.promeg.pinyinhelper.Pinyin;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.b.court.entity.Court;
import com.unicorn.sxshenwutong.b.court.entity.CourtDao;
import com.unicorn.sxshenwutong.b.court.network.CourtFetcher;
import com.unicorn.sxshenwutong.b.login.LoginAct;
import com.unicorn.sxshenwutong.b.userType.network.UserTypeFetcher;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class SplashAct extends BaseAct {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Inject
    CourtDao courtDao;

    @Override
    protected void init(Bundle savedInstanceState) {
        setVmPolicy();
        doALot();
    }

    private void setVmPolicy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
    }

    private void doALot() {
        new RxPermissions(this)
                // 动态申请权限
                .request(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO)
                .flatMap(aBoolean -> {
                    if (!aBoolean) {
                        finish();
                        return Observable.never();
                    }
                    return courtDao.rx().deleteAll();
                }).flatMap(aVoid -> new CourtFetcher().start())
                .flatMap(courtResponse -> {
                            List<Court> courtList = courtResponse.getFylist();
                            for (Court court : courtList) {
                                // 设置拼音，为了索引
                                court.setPinyin(Pinyin.toPinyin(court.getFyjc(), ""));
                            }
                            return courtDao.rx().insertInTx(courtList);
                        }
                )
                .flatMap(courts -> new UserTypeFetcher().start())
                .subscribe(codeResponse -> {
                    Global.setUserTypeList(codeResponse.getBmlist());
                    startActivityAndFinish(LoginAct.class);
                });
    }

}
