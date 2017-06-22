package com.unicorn.sxshenwutong.dagger;

import android.app.Application;
import android.content.Context;

import com.unicorn.sxshenwutong.RetrofitProvider;
import com.unicorn.sxshenwutong.court.data.CourtService;

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
    CourtService provideCourtService(Retrofit retrofit) {
        return retrofit.create(CourtService.class);
    }

}