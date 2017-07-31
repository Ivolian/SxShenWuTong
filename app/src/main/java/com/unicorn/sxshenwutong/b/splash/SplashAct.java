package com.unicorn.sxshenwutong.b.splash;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import com.github.promeg.pinyinhelper.Pinyin;
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
        fetchCourtAndUserType();
    }

    private void setVmPolicy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
    }

    private void fetchCourtAndUserType() {
        courtDao.rx().deleteAll()
                .flatMap(aVoid -> new CourtFetcher().start())
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
