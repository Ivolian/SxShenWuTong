package com.unicorn.sxshenwutong.a.dagger;

import android.content.Context;

import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.b.court.CourtAct;
import com.unicorn.sxshenwutong.b.court.CourtFetcher;
import com.unicorn.sxshenwutong.b.login.LoginFetcher;
import com.unicorn.sxshenwutong.b.userType.UserTypeFetcher;
import com.unicorn.sxshenwutong.ListAct;
import com.unicorn.sxshenwutong.c.home.HomeFra;
import com.unicorn.sxshenwutong.c.main.MainAct;

import dagger.Component;

@App
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();

    void inject(LoginFetcher o);
    void inject(CodeFetcher o);
    void inject(CourtFetcher o);
    void inject(CourtAct o);
    void inject(UserTypeFetcher o);

    void inject(MainAct o);
    void inject(HomeFra o);
    void inject(ListAct o);




}
