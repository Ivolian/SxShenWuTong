package com.unicorn.sxshenwutong.b.userType;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.SimpleButton;
import com.unicorn.sxshenwutong.SimpleResponse;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.b.userType.entity.UserTypeWrapper;
import com.unicorn.sxshenwutong.c.main.MainAct;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindColor;
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
        initRv();
    }


    // ===================== initRv =====================

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    UserTypeAdapter userTypeAdapter = new UserTypeAdapter();

    private void initRv() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userTypeAdapter);
        userTypeAdapter.setNewData(wrappers());
        userTypeAdapter.addHeaderView(new HeaderView(this, null));
        addDivider();
        addConfirmButton();
    }


    // ===================== addDivider =====================

    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    private void addDivider() {
        View view = new View(this, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        layoutParams.setMargins(0, 0, 0, ConvertUtils.dp2px(20));
        view.setBackgroundColor(colorPrimary);
        view.setLayoutParams(layoutParams);
        userTypeAdapter.addHeaderView(view);
    }

    private List<UserTypeWrapper> wrappers() {
        String userTypeDm = Global.getLoginResponse().getUser().getUsertype();
        List<UserTypeWrapper> wrappers = new ArrayList<>();
        for (Code code : Global.getUserTypeList()) {
            UserTypeWrapper wrapper = new UserTypeWrapper();
            wrapper.setCode(code);
            wrapper.setChecked(code.getDm().equals(userTypeDm));
            wrappers.add(wrapper);
        }
        return wrappers;
    }


    private void addConfirmButton() {
        SimpleButton confirmBtn = new SimpleButton(this, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ConvertUtils.dp2px(50));
        layoutParams.setMargins(ConvertUtils.dp2px(20), ConvertUtils.dp2px(30), ConvertUtils.dp2px(20), 0);
        confirmBtn.setLayoutParams(layoutParams);
        confirmBtn.setText("确认");
        confirmBtn.setTextSize(20);
        RxView.clicks(confirmBtn)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> setUserType());
        userTypeAdapter.addFooterView(confirmBtn);
    }


    // ===================== setUserType =====================

    @NotRequired
    @BindExtra(Key.TO_MAIN)
    boolean toMain;

    String userTypeDm;

    private void setUserType() {
        for (UserTypeWrapper wrapper : userTypeAdapter.getData()) {
            if (wrapper.isChecked()) {
                userTypeDm = wrapper.getCode().getDm();
            }
        }
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
