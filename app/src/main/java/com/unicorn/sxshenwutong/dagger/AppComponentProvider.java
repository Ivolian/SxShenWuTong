package com.unicorn.sxshenwutong.dagger;

import android.app.Application;

import com.unicorn.aems.airport.entity.DaoSession;

import dagger.internal.Preconditions;

public class AppComponentProvider {

    private AppComponentProvider() {
    }

    private static AppComponent appComponent;

    public static void init(Application application, DaoSession daoSession) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application, daoSession))
                .build();
    }

    public static AppComponent provide() {
        Preconditions.checkNotNull(appComponent);
        return appComponent;
    }

}
