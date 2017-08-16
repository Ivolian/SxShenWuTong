package com.unicorn.sxshenwutong.db.ajcl.ajcl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class AjclPhotoAct extends AjclAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_ajcl_photo;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clickPhoto();
    }

    @BindView(R.id.ivPhoto)
    ImageView ivPhoto;

    private void clickPhoto() {
        RxView.clicks(ivPhoto)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> MultiImageSelector.create()
                        .showCamera(true)
                        .single()
                        .start(this, Key.REQUEST_CODE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Key.REQUEST_CODE && resultCode == RESULT_OK) {
            filePath = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT).get(0);
            Glide.with(this).load(filePath).into(ivPhoto);
        }
    }

}
