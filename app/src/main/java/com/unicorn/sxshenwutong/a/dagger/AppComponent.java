package com.unicorn.sxshenwutong.a.dagger;

import android.content.Context;

import com.unicorn.sxshenwutong.AjxxFetcher;
import com.unicorn.sxshenwutong.CxbgSubmitter;
import com.unicorn.sxshenwutong.SxbgSubmitter;
import com.unicorn.sxshenwutong.a.code.CodeFetcher;
import com.unicorn.sxshenwutong.b.court.CourtAct;
import com.unicorn.sxshenwutong.b.court.CourtFetcher;
import com.unicorn.sxshenwutong.b.login.LoginFetcher;
import com.unicorn.sxshenwutong.b.userType.UserTypeFetcher;
import com.unicorn.sxshenwutong.c.home.HomeFetcher;
import com.unicorn.sxshenwutong.lc.NextNodeFetcher;
import com.unicorn.sxshenwutong.list.ListAct2;
import com.unicorn.sxshenwutong.userList.UserListFetcher;

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

    void inject(HomeFetcher o);

    void inject(ListAct2 o);
    void inject(AjxxFetcher o);
    void inject(NextNodeFetcher o);
    void inject(UserListFetcher o);
    void inject(CxbgSubmitter o);
    void inject(SxbgSubmitter o);

}
