package com.unicorn.sxshenwutong.dagger;

import android.content.Context;

import com.unicorn.sxshenwutong.CourtAct;
import com.unicorn.sxshenwutong.LoginAct;

import dagger.Component;

@App
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();

    void inject(LoginAct o);
    void inject(CourtAct o);




}
