package com.unicorn.sxshenwutong.d.ajcl;

import android.os.Bundle;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding.view.RxView;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import okhttp3.Call;
import pocketknife.BindExtra;

public class AjclAct extends BaseAct {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @BindExtra(Key.AJBS)
    String ajbs;

    protected String filePath;

    @BindView(R.id.etFileName)
    EditText etFileName;

    @BindView(R.id.etMs)
    EditText etMs;

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        clickSave();
    }

    @Inject
    PostHelper postHelper;

    private void clickSave() {
        RxView.clicks(findViewById(R.id.tvSave))
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    if (filePath == null) {
                        ToastUtils.showShort("尚未添加案件材料");
                        return;
                    }
                    HashMap<String, Object> map = new HashMap<>();
                    map.put(Key.AJBS, ajbs);
                    map.put("title", etFileName.getText().toString().trim());
                    map.put("bz", etMs.getText().toString().trim());
                    postHelper.start2(map, filePath, new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Logger.d(e);
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            ToastUtils.showShort("上传完成");
                            RxBus.get().post(RxBusTag.SUBMIT_SUCCESS, new Object());
                            finish();
                        }
                    });
                });
    }


}
