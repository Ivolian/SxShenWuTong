package com.unicorn.sxshenwutong.userType;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.internal.LinkedTreeMap;
import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.LoginService;
import com.unicorn.sxshenwutong.Params;
import com.unicorn.sxshenwutong.ParamsHelper;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.Response;
import com.unicorn.sxshenwutong.RetrofitProvider;
import com.unicorn.sxshenwutong.base.BaseAct;
import com.unicorn.sxshenwutong.base.Global;
import com.unicorn.sxshenwutong.code.Code;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class UserTypeAct extends BaseAct {
    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

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
        RxView.clicks(btnConfirm).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        setUserType();
                    }
                });
    }




    private void setUserType(){
        UserType userType = null;
        for (UserType o:userTypeAdapter.getData()){
            if (o.isChecked()){
                userType = o;
            }
        }
s(userType);
    }

    @Inject
    ParamsHelper paramsHelper;

    private void s(UserType userType) {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("usertype", userType.getDm());
        paramsHelper.initParams(params, "setUserType", parameters);

        Retrofit retrofit = new RetrofitProvider().provide();
        LoginService loginService = retrofit.create(LoginService.class);
        loginService
                .test(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("");
                    }

                    @Override
                    public void onNext(Response o) {
                        copeResponse(o);
                    }
                });
    }


    private void copeResponse(Response response) {
        if (response.getCode().equals("000000")) {
            LinkedTreeMap<String, String> parameters = (LinkedTreeMap<String, String>) response.getParameters();
            String ydbaKey = parameters.get("ydbaKey");
            try {
                JSONObject jsonObject = new JSONObject(ydbaKey);
                boolean success = jsonObject.getBoolean("success");
                if (success) {
                } else {
                    ToastUtils.showShort("的额");

                }
                Logger.d("");
//                String str = jsonObject.getJSONArray("fylist").toString();
//                List<Court> courts =     new Gson().fromJson(str,
//                        new TypeToken<List<Court>>() {
//                        }.getType());
//                courtAdapter.setNewData(courts);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    @BindView(R.id.btnConfirm)
    Button btnConfirm;

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
