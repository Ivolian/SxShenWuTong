package com.unicorn.sxshenwutong.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.base.BaseAct;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;

import butterknife.BindView;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;

public class MainAct extends BaseAct {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected int layoutResId() {
        return R.layout.act_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initMainTab();
    }


    // ===================== initRv =====================

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.mainTab)
    PageBottomTabLayout mainTab;

    private void initMainTab() {
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        NavigationController navigationController = mainTab.custom()
                .addItem(newItem(R.drawable.sy_2, R.drawable.sy_1, "首页"))
                .addItem(newItem(R.drawable.xw_2, R.drawable.xw_1, "新闻"))
                .addItem(newItem(R.drawable.gj_2, R.drawable.gj_1, "工具"))
                .addItem(newItem(R.drawable.wd_2, R.drawable.wd_1, "我的"))
                .build();
        navigationController.setupWithViewPager(viewPager);
    }

    private BaseTabItem newItem(@DrawableRes int drawableRes, @DrawableRes int checkedDrawableRes, String title) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawableRes, checkedDrawableRes, title);
        normalItemView.setTextDefaultColor(Color.BLACK);
        normalItemView.setTextCheckedColor(Color.parseColor("#9E0203"));
        return normalItemView;
    }
}
