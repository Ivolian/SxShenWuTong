package com.unicorn.sxshenwutong.d.ajcl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.example.mylibrary.http.UploadDownloadlistener;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;

import java.util.HashMap;

import butterknife.BindView;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import pocketknife.BindExtra;

public class AjclPhotoAct extends BaseAct {

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        clickBack();
        RxView.clicks(findViewById(R.id.ivPhoto)).subscribe(aVoid -> {
            MultiImageSelector.create()
                    .showCamera(true)
                    .single()
                    .start(this, 2333);
        });

        RxView.clicks(findViewById(R.id.tvSave)).subscribe(aVoid -> {
            if (path == null) {
                ToastUtils.showShort("请添加照片");
                return;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put(Key.AJBS, ajbs);
            map.put("title", etFileName.getText().toString().trim());
            map.put("bz", etMs.getText().toString().trim());
            new PostHelper().start(this, map, path, new UploadDownloadlistener() {
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

    @BindExtra(Key.AJBS)
    String ajbs;

    @BindView(R.id.ivPhoto)
    ImageView ivPhoto;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2333) {
            if (resultCode == RESULT_OK) {
                // Get the result list of select image paths
                path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT).get(0);
                Glide.with(this).load(path).into(ivPhoto)
                ;
            }
        }
    }


    String path;

    @BindView(R.id.etFileName)
    EditText etFileName;

    @BindView(R.id.etMs)
    EditText etMs;


    @Override
    protected int layoutResId() {
        return R.layout.act_ajcl_photo;
    }
}
