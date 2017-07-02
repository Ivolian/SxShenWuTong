package com.unicorn.sxshenwutong;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.base.BaseFra;
import com.unicorn.sxshenwutong.base.Global;
import com.unicorn.sxshenwutong.userType.UserTypeAct;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.functions.Action1;

public class ProfileFragment extends BaseFra {


    @Override
    protected int layoutResId() {
        return R.layout.fra_profile;
    }

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

    @Override
    protected void init(View rootView) {
        User user = Global.user;
        tvLoginName.setText("姓名:" + user.getLoginName());
        tvCourtName.setText("法院:" + user.getFymc());
        tvDepartmentName.setText("部门:" + user.getDepartname());
        tvMobile.setText("办公电话:" + user.getMobile_phone());
        tvTelephone.setText("联系手机:" + user.getTelephone());

        RxView.clicks(tvLoginName).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Intent intent = new Intent(getActivity(), UserTypeAct.class);
                        startActivity(intent);
                    }
                });
    }
}
