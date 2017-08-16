package com.unicorn.sxshenwutong.a.dagger;

import android.content.Context;

import com.unicorn.sxshenwutong.a.base.AjxxListAct;
import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.b.court.CourtAct;
import com.unicorn.sxshenwutong.b.court.network.CourtFetcher;
import com.unicorn.sxshenwutong.b.login.LoginAct;
import com.unicorn.sxshenwutong.b.login.network.LoginSubmitter;
import com.unicorn.sxshenwutong.b.splash.SplashAct;
import com.unicorn.sxshenwutong.b.userType.network.UserTypeSubmitter;
import com.unicorn.sxshenwutong.c.home.network.HomeFetcher;
import com.unicorn.sxshenwutong.db.ajcl.ajcl.base.AjclAct;
import com.unicorn.sxshenwutong.db.ajcl.list.AjclListAct;
import com.unicorn.sxshenwutong.d.nextNode.NextNodeFetcher;
import com.unicorn.sxshenwutong.d.nextNode.NextUserListFetcher;
import com.unicorn.sxshenwutong.d.spdsp.list.SpdspListAct;
import com.unicorn.sxshenwutong.d.spdsp.sp.network.SpdspFetcher;
import com.unicorn.sxshenwutong.db2.AjxxFetcher;
import com.unicorn.sxshenwutong.db2.ajspSq.AjspsqListAct;
import com.unicorn.sxshenwutong.db.ajws.base.BaseAjwsListAct;
import com.unicorn.sxshenwutong.db.db.DbListAct;
import com.unicorn.sxshenwutong.db2.sxbgSq.SxbgSubmitter;
import com.unicorn.sxshenwutong.db2.sycxbgSq.SycxbgSubmitter;
import com.unicorn.sxshenwutong.db2.wssp.WsspLcidFetcher;
import com.unicorn.sxshenwutong.simple.jasc.JascListAct;
import com.unicorn.sxshenwutong.simple.sx.SxListAct;
import com.unicorn.sxshenwutong.unknown.SimpleSubmitter;
import com.unicorn.sxshenwutong.news.news.network.NewsFetcher;
import com.unicorn.sxshenwutong.news.newsList.NewsListFra;
import com.unicorn.sxshenwutong.news.newsType.network.NewsTypeFetcher;

import dagger.Component;

@App
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();


    // ==================================================================== b start

    // ================= court =================

    void inject(CourtAct o);
    void inject(CourtFetcher o);


    // ================= login =================

    void inject(LoginAct o);
    void inject(LoginSubmitter o);


    // ================= splash =================

    void inject(SplashAct o);


    // ================= userType =================

    void inject(CodeFetcher o);
    void inject(UserTypeSubmitter o);


    // ==================================================================== db start

    void inject(DbListAct o);
    void inject(BaseAjwsListAct o);


    void inject(NewsListFra o);
    void inject(NewsTypeFetcher o);
    void inject(NewsFetcher o);


    void inject(HomeFetcher o);
    void inject(AjspsqListAct o);
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
    void inject(JascListAct o);
    void inject(SxListAct o);
    void inject(AjxxListAct o);
    void inject(AjclAct o);

}
