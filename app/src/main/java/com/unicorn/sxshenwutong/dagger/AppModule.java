package com.unicorn.sxshenwutong.dagger;

import android.app.Application;
import android.content.Context;

import com.unicorn.sxshenwutong.RetrofitProvider;
import com.unicorn.sxshenwutong.code.CodeService;
import com.unicorn.sxshenwutong.court.data.CourtService;
import com.unicorn.sxshenwutong.login.LoginService;

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
    LoginService provideLoginService(Retrofit retrofit) {
        return retrofit.create(LoginService.class);
    }


    @App
    @Provides
    CourtService provideCourtService(Retrofit retrofit) {
        return retrofit.create(CourtService.class);
    }

    @App
    @Provides
    CodeService provideCodeService(Retrofit retrofit) {
        return retrofit.create(CodeService.class);
    }

}
