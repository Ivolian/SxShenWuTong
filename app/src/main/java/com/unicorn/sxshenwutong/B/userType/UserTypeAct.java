package com.unicorn.sxshenwutong.B.userType;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.A.app.Global;
import com.unicorn.sxshenwutong.A.base.BaseAct;
import com.unicorn.sxshenwutong.A.code.entity.Code;
import com.unicorn.sxshenwutong.B.login.entity.User;
import com.unicorn.sxshenwutong.B.userType.entity.UserType;
import com.unicorn.sxshenwutong.B.userType.entity.UserTypeResponse;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.main.MainAct;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import pocketknife.BindExtra;
import pocketknife.NotRequired;

public class UserTypeAct extends BaseAct {


    @Override
    protected int layoutResId() {
        return R.layout.act_user_type;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
    renderUser();
        initRv();
        clickBack();
        clickConfirm();
    }


    // ===================== initRv =====================

    @BindView(R.id.tvLoginName)
    TextView tvLoginName;

    @BindView(R.id.tvCourtName)
    TextView tvCourtName;

    private void renderUser(){
        User user = Global.getLoginResponse().getUser();
        tvLoginName.setText(user.getFullname());
        tvCourtName.setText(user.getFymc());
    }


    // ===================== initRv =====================

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    UserTypeAdapter userTypeAdapter = new UserTypeAdapter();

    private void initRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userTypeAdapter);
        userTypeAdapter.setNewData(userTypes());

    }

    private List<UserType> userTypes() {
        String userTypeDm = Global.getLoginResponse().getUser().getUsertype();
        List<UserType> userTypes = new ArrayList<>();
        for (Code code : Global.getUserTypeCodes()) {
            UserType userType = new UserType();
            userType.setCode(code);
            userType.setChecked(code.getDm().equals(userTypeDm));
            userTypes.add(userType);
        }
        return userTypes;
    }


    // ===================== clickConfirm =====================

    private void clickConfirm(){
        RxView.clicks(findViewById(R.id.btnConfirm))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> setUserType());
    }


    @NotRequired
    @BindExtra("toMain")
    boolean toMain;

    String userTypeDm;

    private void setUserType() {
        userTypeAdapter.getData().stream().filter(UserType::isChecked).forEach(userType -> userTypeDm = userType.getCode().getDm());
        if (userTypeDm == null) {
            ToastUtils.showShort("请选择身份");
            return;
        }
        new UserTypeFetcher(userTypeDm, ydbaKey -> {
            UserTypeResponse userTypeResponse = new Gson().fromJson(ydbaKey, UserTypeResponse.class);
            if (userTypeResponse.isSuccess()) {
                Global.getLoginResponse().getUser().setUsertype(userTypeDm);
                if (toMain) {
                    startActivity(new Intent(this, MainAct.class));
                }
                finish();
            }
        }).start();
    }


}
