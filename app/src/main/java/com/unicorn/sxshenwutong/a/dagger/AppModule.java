package com.unicorn.sxshenwutong.a.dagger;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.app.DaoSessionProvider;
import com.unicorn.sxshenwutong.a.network.GeneralService;
import com.unicorn.sxshenwutong.a.network.RetrofitProvider;
import com.unicorn.sxshenwutong.b.court.entity.CourtDao;
import com.unicorn.sxshenwutong.b.court.entity.DaoSession;
import com.unicorn.sxshenwutong.b.login.entity.LoginInfoDao;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class AppModule {

    private final Application application;

    AppModule(Application application) {
        this.application = application;
    }

    @App
    @Provides
    Context provideContext() {
        return application.getApplicationContext();
    }

    @App
    @Provides
    Application provideApplication() {
        return application;
    }

    @App
    @Provides
    Retrofit provideRetrofit(RetrofitProvider retrofitProvider) {
        return retrofitProvider.provide();
    }

    @App
    @Provides
    GeneralService provideGeneralService(Retrofit retrofit) {
        return retrofit.create(GeneralService.class);
    }

    @App
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @App
    @Provides
    DaoSession provideDaoSession(DaoSessionProvider daoSessionProvider) {
        return daoSessionProvider.provide();
    }

    @App
    @Provides
    LoginInfoDao provideLoginInfoDao(DaoSession daoSession) {
        return daoSession.getLoginInfoDao();
    }

    @App
    @Provides
    CourtDao provideCourtDao(DaoSession daoSession) {
        return daoSession.getCourtDao();
    }

}