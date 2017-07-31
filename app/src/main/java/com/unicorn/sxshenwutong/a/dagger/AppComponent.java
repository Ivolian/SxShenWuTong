package com.unicorn.sxshenwutong.a.dagger;

import android.content.Context;

import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.b.court.CourtAct;
import com.unicorn.sxshenwutong.b.court.network.CourtFetcher;
import com.unicorn.sxshenwutong.b.login.LoginAct;
import com.unicorn.sxshenwutong.b.login.network.LoginSubmitter;
import com.unicorn.sxshenwutong.b.splash.SplashAct;
import com.unicorn.sxshenwutong.b.userType.network.UserTypeSubmitter;
import com.unicorn.sxshenwutong.c.home.network.HomeFetcher;
import com.unicorn.sxshenwutong.d.ajcl.AjclAct;
import com.unicorn.sxshenwutong.d.ajcl.AjclListAct;
import com.unicorn.sxshenwutong.d.ajws.AjwsListAct;
import com.unicorn.sxshenwutong.d.ajws.AjwsSelectListAct;
import com.unicorn.sxshenwutong.d.nextNode.NextNodeFetcher;
import com.unicorn.sxshenwutong.d.nextNode.NextUserListFetcher;
import com.unicorn.sxshenwutong.d.spdb.AjxxFetcher;
import com.unicorn.sxshenwutong.d.spdb.list.ajsqsp.AjspsqListAct;
import com.unicorn.sxshenwutong.d.spdb.list.spdb.SpdbListAct;
import com.unicorn.sxshenwutong.d.spdb.sxbgSq.SxbgSubmitter;
import com.unicorn.sxshenwutong.d.spdb.sycxbgSq.SycxbgSubmitter;
import com.unicorn.sxshenwutong.d.spdb.wssp.WsspLcidFetcher;
import com.unicorn.sxshenwutong.d.spdsp.list.SpdspListAct;
import com.unicorn.sxshenwutong.d.spdsp.sp.network.SpdspFetcher;
import com.unicorn.sxshenwutong.e.base.AjxxListAct;
import com.unicorn.sxshenwutong.e.jasc.JascListAct;
import com.unicorn.sxshenwutong.e.sx.SxListAct;
import com.unicorn.sxshenwutong.f.SimpleSubmitter;

import dagger.Component;

@App
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();

    // ================= court =================

    void inject(CourtAct o);
    void inject(CourtFetcher o);


    // ================= splash =================

    void inject(SplashAct o);


    // ================= userType =================

    void inject(CodeFetcher o);
    void inject(UserTypeSubmitter o);




    void inject(LoginSubmitter o);
    void inject(LoginAct o);
    void inject(HomeFetcher o);
    void inject(SpdbListAct o);
    void inject(AjspsqListAct o);
    void inject(AjwsListAct o);
    void inject(AjxxFetcher o);
    void inject(NextNodeFetcher o);
    void inject(SycxbgSubmitter o);
    void inject(SxbgSubmitter o);
    void inject(NextUserListFetcher o);
    void inject(SpdspListAct o);
    void inject(SpdspFetcher o);
    void inject(SimpleSubmitter o);
    void inject(AjclListAct o);
    void inject(WsspLcidFetcher o);
    void inject(AjwsSelectListAct o);
    void inject(JascListAct o);
    void inject(SxListAct o);
    void inject(AjxxListAct o);
    void inject(AjclAct o);

}
