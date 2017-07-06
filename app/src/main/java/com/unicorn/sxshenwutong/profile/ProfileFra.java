package com.unicorn.sxshenwutong.profile;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.B.login.entity.User;
import com.unicorn.sxshenwutong.A.base.BaseFra;
import com.unicorn.sxshenwutong.A.app.Global;
import com.unicorn.sxshenwutong.userType.UserTypeAct;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.functions.Action1;

public class ProfileFra extends BaseFra {


    @Override
    protected int layoutResId() {
        return R.layout.fra_profile;
    }

    @Override
    protected void init(View rootView) {
        clickSetting();
        renderUser(Global.getLoginResponse().getUser());
    }


    // ===================== clickSetting =====================

    @BindView(R.id.setting)
    FrameLayout setting;

    private void clickSetting() {
        RxView.clicks(setting)
                .throttleFirst(1, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(getActivity(), UserTypeAct.class));
                    }
                });
    }


    // ===================== renderUser =====================

    private void renderUser(@NonNull User user) {
        tvLoginNameT.setText(user.getLoginName());
        tvCourtNameT.setText(user.getFymc());
        tvLoginName.setText("姓名 : " + user.getLoginName());
        tvCourtName.setText("法院 : " + user.getFymc());
        tvDepartmentName.setText("部门 : " + user.getDepartname());
        tvMobile.setText("办公电话 : " + user.getMobile_phone());
        tvTelephone.setText("联系手机 : " + user.getTelephone());
    }


    // ===================== some view =====================

    @BindView(R.id.tvLoginNameT)
    TextView tvLoginNameT;
    @BindView(R.id.tvCourtNameT)
    TextView tvCourtNameT;
    @BindView(R.id.tvLoginName)
    TextView tvLoginName;
    @BindView(R.id.tvCourtName)
    TextView tvCourtName;
    @BindView(R.id.tvDepartmentName)
    TextView tvDepartmentName;
    @BindView(R.id.tvMobile)
    TextView tvMobile;
    @BindView(R.id.tvTelephone)
    TextView tvTelephone;

}
