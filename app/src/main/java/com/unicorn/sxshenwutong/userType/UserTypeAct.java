package com.unicorn.sxshenwutong.userType;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.base.BaseAct;
import com.unicorn.sxshenwutong.base.Global;
import com.unicorn.sxshenwutong.code.Code;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UserTypeAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_user_type;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        s();
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    UserTypeAdapter userTypeAdapter = new UserTypeAdapter();

    private void s() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userTypeAdapter);
        userTypeAdapter.setNewData(tt());
    }

    private List<UserType> tt() {
        List<UserType> userTypes = new ArrayList<>();
        for (Code code : Global.codes) {
            UserType userType = new UserType();
            userType.setDm(code.getDm());
            userType.setDmms(code.getDmms());
            userType.setChecked(false);
            userTypes.add(userType);
        }
        return userTypes;
    }


}
