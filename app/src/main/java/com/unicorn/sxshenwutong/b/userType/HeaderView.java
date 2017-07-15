package com.unicorn.sxshenwutong.b.userType;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.b.login.entity.User;
import com.zhy.android.percent.support.PercentLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderView extends PercentLinearLayout {

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.header_view_usertype, this, true);
        ButterKnife.bind(this);
        renderUser();
    }

    @BindView(R.id.tvLoginName)
    TextView tvLoginName;

    @BindView(R.id.tvCourtName)
    TextView tvCourtName;

    private void renderUser() {
        User user = Global.getLoginResponse().getUser();
        tvLoginName.setText(user.getFullname());
        tvCourtName.setText(user.getFymc());
    }

}
