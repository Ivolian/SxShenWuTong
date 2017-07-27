package com.unicorn.sxshenwutong.d.ajcl;

import android.os.Bundle;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.example.mylibrary.http.UploadDownloadlistener;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;

import java.util.HashMap;

import butterknife.BindView;
import pocketknife.BindExtra;

abstract public class AjclAct extends BaseAct {

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

    private void clickSave() {
        RxView.clicks(findViewById(R.id.tvSave)).subscribe(aVoid -> {
            if (filePath == null) {
                ToastUtils.showShort("尚未添加案件材料");
                return;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put(Key.AJBS, ajbs);
            map.put("title", etFileName.getText().toString().trim());
            map.put("bz", etMs.getText().toString().trim());
            new PostHelper().start2(this, map, filePath, new UploadDownloadlistener() {
                @Override
                public void onStartDownLoad() {

                }

                @Override
                public void onCompleteRateChanged(int i) {

                }

                @Override
                public void onDownloadCompleted(String s) {
                    ToastUtils.showShort("上传完成");
                    finish();
                }
            });
        });
    }


}
