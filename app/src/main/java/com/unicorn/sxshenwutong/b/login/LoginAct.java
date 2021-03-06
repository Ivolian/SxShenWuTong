package com.unicorn.sxshenwutong.b.login;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.b.court.CourtAct;
import com.unicorn.sxshenwutong.b.court.entity.Court;
import com.unicorn.sxshenwutong.b.login.entity.LoginInfo;
import com.unicorn.sxshenwutong.b.login.entity.LoginInfoDao;
import com.unicorn.sxshenwutong.b.login.entity.LoginResponse;
import com.unicorn.sxshenwutong.b.login.network.LoginSubmitter;
import com.unicorn.sxshenwutong.b.userType.UserTypeAct;
import com.unicorn.sxshenwutong.c.main.MainAct;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class LoginAct extends BaseAct {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected boolean useRxBus() {
        return true;
    }

    @Override
    protected int layoutResId() {
        return R.layout.act_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        loadImg();
        setBg();
        clickCourt();
        clickLogin();
        renderLoginInfo();
    }


    // ===================== loadImg =====================

    private void loadImg() {
        Glide.with(this).load(R.drawable.login_top).into(ivTop);
    }


    // ===================== setBg =====================

    private void setBg() {
        setIvBg(ivCourt);
        setIvBg(ivLoginName);
        setIvBg(ivPwd);
        setLlBg(llCourt);
        setLlBg(llLoginName);
        setLlBg(llPwd);
    }

    @BindColor(R.color.login)
    int login;

    private void setIvBg(ImageView imageView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        int radii = 20;
        gradientDrawable.setCornerRadii(new float[]{radii, radii, 0, 0, 0, 0, radii, radii});
        gradientDrawable.setColor(login);
        imageView.setBackground(gradientDrawable);
    }

    private void setLlBg(LinearLayout linearLayout) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20);
        gradientDrawable.setColor(Color.WHITE);
        linearLayout.setBackground(gradientDrawable);
    }


    // ===================== clickCourt =====================

    private void clickCourt() {
        RxView.clicks(llCourt)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> startActivity(new Intent(this, CourtAct.class)));
    }

    private Court court;

    @Subscribe(tags = {@Tag(RxBusTag.SELECT_COURT)})
    public void onCourtSelect(Court court) {
        this.court = court;
        tvCourt.setText(court.getDmms());
    }


    // ===================== clickLogin =====================

    private void clickLogin() {
        RxView.clicks(findViewById(R.id.btnLogin))
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> login());
    }

    private void login() {
        if (court == null) {
            ToastUtils.showShort("请选择法院");
            return;
        }
        if (StringUtils.isEmpty(etLoginName.getText().toString().trim())) {
            ToastUtils.showShort("请填写用户名");
            return;
        }
        if (StringUtils.isEmpty(etPwd.getText().toString().trim())) {
            ToastUtils.showShort("请填写密码");
            return;
        }
        new LoginSubmitter(
                court.getDm(),
                etLoginName.getText().toString().trim(),
                etPwd.getText().toString().trim()
        ).start().subscribe(new Subscriber<LoginResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginResponse loginResponse) {
                if (loginResponse.isSuccess()) {
                    Global.setLoginResponse(loginResponse);
                    saveLoginInfo();
                    String userTypeDm = Global.getLoginResponse().getUser().getUsertype();
                    if (userTypeDm == null || userTypeDm.equals("")) {
                        Intent intent = new Intent(LoginAct.this, UserTypeAct.class);
                        intent.putExtra(Key.TO_MAIN, true);
                        startActivity(intent);
                    } else {
                        startActivity(MainAct.class);
                    }
                    finish();
                } else {
                    ToastUtils.showShort("用户名或密码错误");
                }
            }
        });
    }


    // ===================== loginInfo =====================

    @Inject
    LoginInfoDao loginInfoDao;

    private void saveLoginInfo() {
        loginInfoDao.rx().deleteAll()
                .flatMap(aVoid -> loginInfoDao.rx().insert(
                        new LoginInfo(
                                etLoginName.getText().toString().trim(),
                                etPwd.getText().toString().trim(),
                                court.getDm()
                        )
                ))
                .subscribe(loginInfo -> {
                });
    }

    private void renderLoginInfo() {
        loginInfoDao.queryBuilder().rx()
                .unique()
                .observeOn(AndroidSchedulers.mainThread())
                .filter(loginInfo -> loginInfo != null)
                .subscribe(loginInfo -> {
                            this.court = loginInfo.getCourt();
                            tvCourt.setText(court.getDmms());
                            etLoginName.setText(loginInfo.getLoginName());
                            etPwd.setText(loginInfo.getPwd());
                        }
                );
    }


    // ===================== some view =====================

    @BindView(R.id.ivTop)
    ImageView ivTop;
    @BindView(R.id.llCourt)
    LinearLayout llCourt;
    @BindView(R.id.tvCourt)
    TextView tvCourt;
    @BindView(R.id.etLoginName)
    EditText etLoginName;
    @BindView(R.id.etPwd)
    EditText etPwd;
    @BindView(R.id.llLoginName)
    LinearLayout llLoginName;
    @BindView(R.id.llPwd)
    LinearLayout llPwd;
    @BindView(R.id.ivCourt)
    ImageView ivCourt;
    @BindView(R.id.ivLoginName)
    ImageView ivLoginName;
    @BindView(R.id.ivPwd)
    ImageView ivPwd;

}
