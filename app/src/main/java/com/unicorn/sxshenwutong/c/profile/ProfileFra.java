package com.unicorn.sxshenwutong.c.profile;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;

import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseFra;
import com.unicorn.sxshenwutong.b.login.entity.User;
import com.unicorn.sxshenwutong.b.userType.UserTypeAct;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class ProfileFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.fra_profile;
    }

    @Override
    protected void init(View rootView) {
        clickSetting();
        renderUser();
    }


    // ===================== clickSetting =====================

    @BindView(R.id.setting)
    FrameLayout setting;

    private void clickSetting() {
        RxView.clicks(setting)
                .throttleFirst(1, TimeUnit.MILLISECONDS)
                .subscribe(aVoid -> startActivity(new Intent(getActivity(), UserTypeAct.class)));
    }


    // ===================== renderUser =====================

    private void renderUser() {
        User user = Global.getLoginResponse().getUser();
        setText(R.id.tvLoginNameT, user.getFullname());
        setText(R.id.tvCourtNameT, user.getFymc());
        setText(R.id.tvLoginName, "姓名 : " + user.getFullname());
        setText(R.id.tvCourtName, "法院 : " + user.getFymc());
        setText(R.id.tvDepartmentName, "部门 : " + user.getDept_name());
        setText(R.id.tvMobile,"办公电话: " + user.getOffice_phone());
        setText(R.id.tvTelephone,"联系手机 : " + user.getPhone());
    }


}
