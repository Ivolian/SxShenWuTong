package com.unicorn.sxshenwutong.B.login;

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
import com.google.gson.Gson;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.A.app.Global;
import com.unicorn.sxshenwutong.A.base.BaseAct;
import com.unicorn.sxshenwutong.A.code.CodeFetcher;
import com.unicorn.sxshenwutong.A.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.A.constant.Key;
import com.unicorn.sxshenwutong.A.constant.RxBusTag;
import com.unicorn.sxshenwutong.B.court.CourtAct;
import com.unicorn.sxshenwutong.B.court.entity.Court;
import com.unicorn.sxshenwutong.B.login.entity.LoginResponse;
import com.unicorn.sxshenwutong.main.MainAct;
import com.unicorn.sxshenwutong.userType.UserTypeAct;

import java.util.concurrent.TimeUnit;

import butterknife.BindColor;
import butterknife.BindView;

import static com.unicorn.sxshenwutong.A.constant.Key.USER_TYPE_CODE;

public class LoginAct extends BaseAct {

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

        etLoginName.setText("审判管理员");
        etPwd.setText("67673305");
    }


    // ===================== loadImg =====================

    private void loadImg() {
        Glide.with(this).load(R.drawable.login_bg).into(ivBg);
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
                etPwd.getText().toString().trim(),
                response -> {
                    LoginResponse loginResponse = new Gson().fromJson(response, LoginResponse.class);
                    if (loginResponse.isSuccess()) {
                        Global.setLoginResponse(loginResponse);
                        getUserTypeCodes();
                    } else {
                        ToastUtils.showShort("用户名或密码错误");
                    }

                }
        ).start();
    }


    // ===================== getUserTypeCodes =====================

    private void getUserTypeCodes() {
        new CodeFetcher(USER_TYPE_CODE, response -> {
            CodeResponse codeResponse = new Gson().fromJson(response, CodeResponse.class);
            Global.setUserTypeCodes(codeResponse.getBmlist());
            String userType = Global.getLoginResponse().getUser().getUsertype();
            if (userType == null || userType.equals("")) {
                Intent intent = new Intent(this, UserTypeAct.class);
                intent.putExtra(Key.TO_MAIN, true);
                startActivity(intent);
            } else {
                startActivity(new Intent(this, MainAct.class));
            }
            finish();

        }).start();
    }


    // ===================== some view =====================

    @BindView(R.id.ivBg)
    ImageView ivBg;
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
