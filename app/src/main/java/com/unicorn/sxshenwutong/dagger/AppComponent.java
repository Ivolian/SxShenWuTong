package com.unicorn.sxshenwutong.dagger;

import android.content.Context;

import com.unicorn.sxshenwutong.ListAct;
import com.unicorn.sxshenwutong.court.CourtAct;
import com.unicorn.sxshenwutong.home.HomeFra;
import com.unicorn.sxshenwutong.login.LoginHelper;
import com.unicorn.sxshenwutong.main.MainAct;
import com.unicorn.sxshenwutong.userType.UserTypeAct;

import dagger.Component;

@App
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();

    void inject(LoginHelper o);
    void inject(CourtAct o);
    void inject(UserTypeAct o);
    void inject(MainAct o);
    void inject(HomeFra o);
    void inject(ListAct o);




}
