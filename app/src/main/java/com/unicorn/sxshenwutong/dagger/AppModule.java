package com.unicorn.sxshenwutong.dagger;

import android.app.Application;
import android.content.Context;

import com.unicorn.aems.airport.entity.AirportDao;
import com.unicorn.aems.airport.entity.DaoSession;
import com.unicorn.aems.app.RetrofitProvider;
import com.unicorn.aems.chart.ChartItemConfigServe;
import com.unicorn.aems.chart.ChartServe;
import com.unicorn.aems.func.menu.ChartConfigServe;
import com.unicorn.aems.func.menu.MenuService;
import com.unicorn.aems.home.HomeMenuService;
import com.unicorn.aems.login.LoginService;
import com.unicorn.aems.login.entity.LoginInfoDao;
import com.unicorn.aems.other.abnormalData.AbnormalDataService;
import com.unicorn.aems.other.document.DocumentService;
import com.unicorn.aems.strategy.StrategyService;
import com.unicorn.aems.update.UpdateService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class AppModule {

    private final Context context;

    private final DaoSession daoSession;

    AppModule(Application application, DaoSession daoSession) {
        this.context = application.getApplicationContext();
        this.daoSession = daoSession;
    }

    @App
    @Provides
    Context provideContext() {
        return context;
    }

    @App
    @Provides
    DaoSession provideDaoSession() {
        return daoSession;
    }

    @App
    @Provides
    AirportDao provideAirportDao(DaoSession daoSession) {
        return daoSession.getAirportDao();
    }


    //    @App
    @Provides
    Retrofit provideRetrofit(RetrofitProvider retrofitProvider) {
        return retrofitProvider.provide();
    }

    @App
    @Provides
    LoginService provideLoginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }

    @App
    @Provides
    StrategyService provideStrategyServe(Retrofit retrofit) {
        return retrofit.create(StrategyService.class);
    }

    @App
    @Provides
    AbnormalDataService provideAbnormalServe(Retrofit retrofit) {
        return retrofit.create(AbnormalDataService.class);
    }

    @App
    @Provides
    DocumentService provideDocumentServe(Retrofit retrofit) {
        return retrofit.create(DocumentService.class);
    }

    @App
    @Provides
    ChartConfigServe provideChartConfigServe(Retrofit retrofit) {
        return retrofit.create(ChartConfigServe.class);
    }

    @App
    @Provides
    UpdateService provideUpdateService(Retrofit retrofit) {
        return retrofit.create(UpdateService.class);
    }

    @App
    @Provides
    ChartItemConfigServe provideChartItemConfigServe(Retrofit retrofit) {
        return retrofit.create(ChartItemConfigServe.class);
    }

    @App
    @Provides
    ChartServe provideChartServe(Retrofit retrofit) {
        return retrofit.create(ChartServe.class);
    }

    @App
    @Provides
    HomeMenuService provideHomeMenuService(Retrofit retrofit) {
        return retrofit.create(HomeMenuService.class);
    }


    @App
    @Provides
    MenuService provideMenuService(Retrofit retrofit) {
        return retrofit.create(MenuService.class);
    }

    @App
    @Provides
    LoginInfoDao provideLoginInfoDao(DaoSession daoSession) {
        return daoSession.getLoginInfoDao();
    }

}
