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
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.b.court.CourtAct;
import com.unicorn.sxshenwutong.b.court.entity.Court;
import com.unicorn.sxshenwutong.b.login.entity.LoginInfo;
import com.unicorn.sxshenwutong.b.login.entity.LoginInfoDao;
import com.unicorn.sxshenwutong.b.login.entity.LoginResponse;
import com.unicorn.sxshenwutong.b.userType.UserTypeAct;
import com.unicorn.sxshenwutong.b.userType.network.UserTypeFetcher;

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

        etLoginName.setText("审判管理员");
        etPwd.setText("67673305");
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
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> startActivity(new Intent(this, CourtAct.class)));
    }

    Court court;

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
        if (StringUtils.isTrimEmpty(etLoginName.getText().toString())) {
            ToastUtils.showShort("请填写用户名");
            return;
        }
        if (StringUtils.isTrimEmpty(etPwd.getText().toString())) {
            ToastUtils.showShort("请填写密码");
            return;
        }
        new LoginFetcher(
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
                    getUserType();
                } else {
                    ToastUtils.showShort("用户名或密码错误");
                }
            }
        });
    }


    // ===================== getUserType =====================

    private void getUserType() {
        new UserTypeFetcher().start().subscribe(new Subscriber<CodeResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CodeResponse codeResponse) {
                saveLoginInfo();
                Global.setUserTypeList(codeResponse.getBmlist());
                String userTypeDm = Global.getLoginResponse().getUser().getUsertype();
//                if (userTypeDm == null || userTypeDm.equals("")) {
                Intent intent = new Intent(LoginAct.this, UserTypeAct.class);
                intent.putExtra(Key.TO_MAIN, true);
                startActivity(intent);
//                } else {
//                    startActivity(new Intent(LoginAct.this, MainAct.class));
//                }
                finish();
            }
        });
    }

    @Inject
    LoginInfoDao loginInfoDao;

    private void saveLoginInfo() {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginName(etLoginName.getText().toString().trim());
        loginInfo.setPwd(etPwd.getText().toString().trim());
        loginInfo.setCourt(court);
        loginInfoDao.rx().insertOrReplace(loginInfo).subscribe(loginInfo1 -> {
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
