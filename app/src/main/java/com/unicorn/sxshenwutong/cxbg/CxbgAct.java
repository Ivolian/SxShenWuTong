package com.unicorn.sxshenwutong.cxbg;

import android.os.Bundle;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.AjxxFetcher;
import com.unicorn.sxshenwutong.CxbglxCodeFetcher;
import com.unicorn.sxshenwutong.NextNodeFetcher;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.SycxlxCodeFetcher;
import com.unicorn.sxshenwutong.userList.UserListFetcher;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.code.entity.CodeResponse;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.list.Ajxx;
import com.unicorn.sxshenwutong.userList.UserListResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pocketknife.BindExtra;

public class CxbgAct extends BaseAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_cxbg;
    }

    @BindExtra(Key.AJBS)
    String ajbs;

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        new AjxxFetcher(ajbs, this::renderAjxx).start();


    }

    @BindView(R.id.msCxbglx)
    MaterialSpinner msCxbglx;
    @BindView(R.id.msSycxlx)
    MaterialSpinner msSycxlx;
    List<Code> codes;
    List<Code> codes2;

    private void renderAjxx(Ajxx ajxx) {
        tvTitle.setText(ajxx.getAhqc() + "适用程序变更审批");
        tvAhqc.setText(ajxx.getAhqc());
        tvLarq.setText(ajxx.getLarq());
        tvJarq.setText(ajxx.getJarq());
        tvLaay.setText(ajxx.getLaaymc());
        tvDyyg.setText(ajxx.getDyyg());
        tvDybg.setText(ajxx.getDybg());
        tvSycxmc.setText(ajxx.getSycxmc());

        new CxbglxCodeFetcher(ajxx.getBzzh(), new Callback<CodeResponse>() {
            @Override
            public void onSuccess(CodeResponse codeResponse) {
                codes = codeResponse.getBmlist();
                List<String> list = new ArrayList<String>();
                for (Code code : codes) {
                    list.add(code.getDmms());
                }
                msCxbglx.setItems(list);
                msCxbglx.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                        Code code = codes.get(position);
                        new SycxlxCodeFetcher(ajxx, code, new Callback<CodeResponse>() {
                            @Override
                            public void onSuccess(CodeResponse codeResponse) {
                                codes2 = codeResponse.getBmlist();
                                List<String> list = new ArrayList<String>();
                                for (Code code : codes2) {
                                    list.add(code.getDmms());
                                }
                                msSycxlx.setItems(list);
                            }
                        }).start();
                    }
                });
            }
        }).start();

        new NextNodeFetcher(new Callback<Object>() {
            @Override
            public void onSuccess(Object o) {

            }
        }).start();

        new UserListFetcher(new Callback<UserListResponse>() {
            @Override
            public void onSuccess(UserListResponse o) {
                Logger.d(o);
            }
        }).start();
    }


    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvAhqc)
    TextView tvAhqc;
    @BindView(R.id.tvLarq)
    TextView tvLarq;
    @BindView(R.id.tvJarq)
    TextView tvJarq;
    @BindView(R.id.tvLaay)
    TextView tvLaay;
    @BindView(R.id.tvDyyg)
    TextView tvDyyg;
    @BindView(R.id.tvDybg)
    TextView tvDybg;
    @BindView(R.id.tvSycxmc)
    TextView tvSycxmc;

}
