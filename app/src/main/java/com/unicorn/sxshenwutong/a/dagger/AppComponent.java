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
import com.unicorn.sxshenwutong.nextNode.NextNodeFetcher;
import com.unicorn.sxshenwutong.nextNode.NextUserListFetcher;
import com.unicorn.sxshenwutong.dsp.DspListAct;
import com.unicorn.sxshenwutong.dsp2.base.network.DspFetcher;
import com.unicorn.sxshenwutong.db2.base.AjxxFetcher;
import com.unicorn.sxshenwutong.db.ajspSq.AjspSqListAct;
import com.unicorn.sxshenwutong.db.ajws.base.BaseAjwsListAct;
import com.unicorn.sxshenwutong.db.db.DbListAct;
import com.unicorn.sxshenwutong.db2.fdsySq.FdsySubmitter;
import com.unicorn.sxshenwutong.db2.sycxbgSq.SycxbgSubmitter;
import com.unicorn.sxshenwutong.db2.wsspSq.lcid.LcidFetcher;
import com.unicorn.sxshenwutong.simple.jasc.JascListAct;
import com.unicorn.sxshenwutong.simple.sx.SxListAct;
import com.unicorn.sxshenwutong.other.SimpleSubmitter;
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
    void inject(AjspSqListAct o);
    void inject(AjxxFetcher o);
    void inject(NextNodeFetcher o);
    void inject(SycxbgSubmitter o);
    void inject(FdsySubmitter o);
    void inject(NextUserListFetcher o);
    void inject(DspListAct o);
    void inject(DspFetcher o);
    void inject(SimpleSubmitter o);
    void inject(AjclListAct o);
    void inject(LcidFetcher o);
    void inject(JascListAct o);
    void inject(SxListAct o);
    void inject(AjxxListAct o);
    void inject(AjclAct o);

}
