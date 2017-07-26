package com.unicorn.sxshenwutong.a.dagger;

import android.content.Context;

import com.unicorn.sxshenwutong.SimpleSubmitter;
import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.b.court.CourtAct;
import com.unicorn.sxshenwutong.b.court.CourtFetcher;
import com.unicorn.sxshenwutong.b.login.LoginAct;
import com.unicorn.sxshenwutong.b.login.LoginFetcher;
import com.unicorn.sxshenwutong.b.userType.network.UserTypeSubmitter;
import com.unicorn.sxshenwutong.c.home.HomeFetcher;
import com.unicorn.sxshenwutong.d.ajws.AjwsListAct;
import com.unicorn.sxshenwutong.d.ajws.AjwsSelectListAct;
import com.unicorn.sxshenwutong.d.jasc.JascListAct;
import com.unicorn.sxshenwutong.d.nextNode.NextNodeFetcher;
import com.unicorn.sxshenwutong.d.nextNode.NextUserListFetcher;
import com.unicorn.sxshenwutong.d.spdb.AjxxFetcher;
import com.unicorn.sxshenwutong.d.spdb.list.ajcl.AjclListAct;
import com.unicorn.sxshenwutong.d.spdb.list.ajsqsp.AjspsqListAct;
import com.unicorn.sxshenwutong.d.spdb.list.spdb.SpdbListAct;
import com.unicorn.sxshenwutong.d.spdb.sxbgSq.SxbgSubmitter;
import com.unicorn.sxshenwutong.d.spdb.sycxbgSq.SycxbgSubmitter;
import com.unicorn.sxshenwutong.d.spdb.wssp.WsspLcidFetcher;
import com.unicorn.sxshenwutong.d.spdsp.list.SpdspListAct;
import com.unicorn.sxshenwutong.d.spdsp.sp.network.SpdspFetcher;

import dagger.Component;

@App
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();

    void inject(LoginFetcher o);
    void inject(CodeFetcher o);
    void inject(CourtFetcher o);
    void inject(UserTypeSubmitter o);

    void inject(LoginAct o);
    void inject(CourtAct o);
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

}
