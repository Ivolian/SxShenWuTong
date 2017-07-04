package com.unicorn.sxshenwutong;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.base.BaseAct;
import com.unicorn.sxshenwutong.base.Global;
import com.unicorn.sxshenwutong.constant.RxBusTag;
import com.unicorn.sxshenwutong.court.Court;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.main.MainAct;
import com.unicorn.sxshenwutong.userType.UserTypeAct;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginAct extends BaseAct {

    @Override
    protected boolean useRxBus() {
        return true;
    }

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected int layoutResId() {
        return R.layout.act_login;
    }

    @BindView(R.id.tvCourt)
    TextView tvCourt;

    @BindView(R.id.etLoginName)
    EditText etLoginName;

    @BindView(R.id.etPwd)
    EditText etPwd;

    @BindView(R.id.ivBg)
    ImageView root;
    @BindView(R.id.ivTop)
    ImageView ivTop;

    @BindView(R.id.llLoginName)
    LinearLayout llLoginName;

    @BindView(R.id.ivLoginName)
    ImageView ivLoginName;

    @BindView(R.id.llPwd)
    LinearLayout llPwd;

    @BindView(R.id.ivPwd)
    ImageView ivPwd;


    @Override
    protected void init(Bundle savedInstanceState) {
        etLoginName.setText("审判管理员");
        etPwd.setText("67673305");

        ss2(ivCourt);
        ss2(ivLoginName);
        ss2(ivPwd);

        ss(llLoginName);
        ss(llCourt);
        ss(llPwd);
        RxView.clicks(tvCourt).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                startActivity(new Intent(LoginAct.this, CourtAct.class));
            }
        });

        RxView.clicks(findViewById(R.id.btnLogin)).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                login();
            }
        });

        Glide.with(this).load(R.drawable.login_bg).into(root);
        Glide.with(this).load(R.drawable.login_top).into(ivTop);

    }

    @BindView(R.id.llCourt)
    LinearLayout llCourt;

    private void login() {
        if (court == null) {
            ToastUtils.showShort("请选择法院");
            return;
        }
        if (StringUtils.isTrimEmpty(etLoginName.getText().toString())) {
            ToastUtils.showShort("请填写用户名");
            return;
        }
        if (StringUtils.isTrimEmpty(etPwd.getText().toString())) {
            ToastUtils.showShort("请填写密码");
            return;
        }
        s();
    }


    private void ss(View textView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(20);
        gradientDrawable.setColor(Color.WHITE);
        textView.setBackground(gradientDrawable);
    }

    @BindView(R.id.ivCourt)
    ImageView ivCourt;

    @BindColor(R.color.login)
    int login;

    private void ss2(View textView) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{20, 20, 0, 0, 0, 0, 20, 20});
        gradientDrawable.setColor(login);
        textView.setBackground(gradientDrawable);
    }


    Court court;

    @Subscribe(tags = {@Tag(RxBusTag.SELECT_COURT)})
    public void onCourtSelect(Court court) {
        this.court = court;
        tvCourt.setText(court.getDmms());
    }


    @Inject
    ParamsHelper paramsHelper;

    private void s() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fydm", court.getDm());
        parameters.put("loginname", etLoginName.getText().toString().trim());
        parameters.put("password", etPwd.getText().toString().trim());
        paramsHelper.initParams(params, "login", parameters);

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
                    String ticket = jsonObject.getString("ticket");
                    paramsHelper.setTicket(ticket);
                    JSONObject userJ = jsonObject.getJSONObject("user");
                    User user = new Gson().fromJson(userJ.toString(), User.class);
                    s(user);
                } else {
                    ToastUtils.showShort("登录失败");

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

    private void s(User user) {
        Global.user = user;
        String userType = user.getUsertype();
        if (userType == null || userType.equals("")) {
            Intent intent = new Intent(this, UserTypeAct.class);
            intent.putExtra("toMain", true);
            startActivity(intent);
        } else {
            startActivity(new Intent(this, MainAct.class));
            ToastUtils.showShort("用户名或密码错误");
        }

        finish();
    }


}
