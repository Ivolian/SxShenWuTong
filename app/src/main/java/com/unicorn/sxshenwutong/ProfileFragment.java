package com.unicorn.sxshenwutong;

import android.view.View;
import android.widget.TextView;

import com.unicorn.sxshenwutong.base.BaseFra;
import com.unicorn.sxshenwutong.base.Global;

import butterknife.BindView;

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
    }
}
