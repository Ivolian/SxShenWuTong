package com.unicorn.sxshenwutong.a.dagger;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.a.app.GeneralService;
import com.unicorn.sxshenwutong.a.app.GeneralService2;
import com.unicorn.sxshenwutong.a.app.RetrofitProvider;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class AppModule {

    private final Context context;

    AppModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @App
    @Provides
    Context provideContext() {
        return context;
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
    GeneralService2 provideGeneralService2(Retrofit retrofit) {
        return retrofit.create(GeneralService2.class);
    }

    @App
    @Provides
    Gson provideGson() {
        return new Gson();
    }

}
