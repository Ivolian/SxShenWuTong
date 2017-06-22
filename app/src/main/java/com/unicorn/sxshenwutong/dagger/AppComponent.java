package com.unicorn.sxshenwutong.dagger;

import android.content.Context;

import com.unicorn.aems.airport.AirportAct;
import com.unicorn.aems.chart.ChartHelper;
import com.unicorn.aems.func.FuncFra;
import com.unicorn.aems.func.menu.MenuFra;
import com.unicorn.aems.func.menu.MenuHelper;
import com.unicorn.aems.home.HeaderView;
import com.unicorn.aems.home.HomeAdapter;
import com.unicorn.aems.home.HomeChartAct;
import com.unicorn.aems.home.HomeFra;
import com.unicorn.aems.home.HomeHelper;
import com.unicorn.aems.home.l2.L2Fra;
import com.unicorn.aems.home.l3.L3Act;
import com.unicorn.aems.login.FingerFra;
import com.unicorn.aems.login.LoginAct;
import com.unicorn.aems.login.LoginFra;
import com.unicorn.aems.login.LoginHelper;
import com.unicorn.aems.main.MainAct;
import com.unicorn.aems.other.OtherFra;
import com.unicorn.aems.other.abnormalData.AbnormalDataFra;
import com.unicorn.aems.other.document.DocumentFra;
import com.unicorn.aems.other.document.DocumentHelper;
import com.unicorn.aems.profile.ModifyPwdAct;
import com.unicorn.aems.profile.ProfileFra;
import com.unicorn.aems.splash.SplashAct;
import com.unicorn.aems.strategy.StrategyFra;

import dagger.Component;

@App
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context provideContext();

    void inject(SplashAct o);

    void inject(LoginAct o);

    void inject(MainAct o);

    void inject(AirportAct o);

    void inject(ModifyPwdAct o);

    void inject(HomeChartAct o);


    void inject(LoginFra o);

    void inject(FingerFra o);

    void inject(MenuFra o);

    void inject(FuncFra o);

    void inject(HomeFra o);

    void inject(StrategyFra o);

    void inject(AbnormalDataFra o);

    void inject(DocumentFra o);

    void inject(ProfileFra o);

    void inject(OtherFra o);


    void inject(LoginHelper o);

    void inject(DocumentHelper o);

    void inject(MenuHelper o);

    void inject(ChartHelper o);

    void inject(HomeHelper o);

    void inject(HomeAdapter o);

    void inject(L2Fra o);
    void inject(L3Act o);
    void inject(HeaderView o);


}
