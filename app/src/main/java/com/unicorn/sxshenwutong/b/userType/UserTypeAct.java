package com.unicorn.sxshenwutong.b.userType;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.SimpleResponse;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.b.login.ui.LoginButton;
import com.unicorn.sxshenwutong.b.userType.entity.UserTypeWrapper;
import com.unicorn.sxshenwutong.c.main.MainAct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pocketknife.BindExtra;
import pocketknife.NotRequired;
import rx.Subscriber;

public class UserTypeAct extends BaseAct {


    @Override
    protected int layoutResId() {
        return R.layout.act_user_type;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        clickConfirm();
        initRv();
    }


    // ===================== initRv =====================

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    UserTypeAdapter userTypeAdapter = new UserTypeAdapter();

    private void initRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userTypeAdapter);
        userTypeAdapter.addHeaderView(new HeaderView(this, null));
        userTypeAdapter.setNewData(userTypes());
        View view = new View(this, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        layoutParams.setMargins(0,0,0, ConvertUtils.dp2px(20));
        view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        view.setLayoutParams(layoutParams);
        userTypeAdapter.addHeaderView(view);
        LoginButton loginButton = new LoginButton(this, null);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,  ConvertUtils.dp2px(50));
        layoutParams2.setMargins( ConvertUtils.dp2px(20), ConvertUtils.dp2px(20), ConvertUtils.dp2px(20),0);
        loginButton.setTextSize(20, TypedValue.COMPLEX_UNIT_DIP);
        loginButton.setLayoutParams(layoutParams2);
        loginButton.setClickable(true);
        loginButton.setText("确认");

        userTypeAdapter.addFooterView(loginButton);

    }

    private List<UserTypeWrapper> userTypes() {
        String userTypeDm = Global.getLoginResponse().getUser().getUsertype();
        List<UserTypeWrapper> userTypes = new ArrayList<>();
        for (Code code : Global.getUserTypeList()) {
            UserTypeWrapper userType = new UserTypeWrapper();
            userType.setCode(code);
            userType.setChecked(code.getDm().equals(userTypeDm));
            userTypes.add(userType);
        }
        return userTypes;
    }


    // ===================== setUserType =====================

    private void clickConfirm() {
//        RxView.clicks(findViewById(R.id.btnConfirm))
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .subscribe(aVoid -> setUserType());
    }

    @NotRequired
    @BindExtra(Key.TO_MAIN)
    boolean toMain;

    String userTypeDm;

    private void setUserType() {
        userTypeAdapter.getData().stream().filter(UserTypeWrapper::isChecked).forEach(userType -> userTypeDm = userType.getCode().getDm());
        if (userTypeDm == null) {
            ToastUtils.showShort("请选择身份");
            return;
        }
        new UserTypeSubmitter(userTypeDm).start().subscribe(new Subscriber<SimpleResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SimpleResponse simpleResponse) {
                if (simpleResponse.isSuccess()) {
                    Global.getLoginResponse().getUser().setUsertype(userTypeDm);
                    if (toMain) {
                        startActivity(new Intent(UserTypeAct.this, MainAct.class));
                    }
                    finish();
                }
            }
        });
    }


}
