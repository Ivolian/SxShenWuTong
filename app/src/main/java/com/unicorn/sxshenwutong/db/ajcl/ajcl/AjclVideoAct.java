package com.unicorn.sxshenwutong.db.ajcl.ajcl;

import android.content.Intent;
import android.os.Bundle;

import com.afollestad.materialcamera.MaterialCamera;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import butterknife.BindView;

public class AjclVideoAct extends AjclAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_ajcl_video;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clickBack();
        clickVideo();
        try {
            ivVideo.setRawData(R.raw.portrait_sample);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BindView(R.id.ivVideo)
    ScalableVideoView ivVideo;

    private void clickVideo() {
        RxView.clicks(ivVideo).subscribe(aVoid -> new MaterialCamera(this)
                .allowRetry(true)
                .autoSubmit(false)
                .primaryColorAttr(R.attr.colorPrimary)
                .showPortraitWarning(false)
                .defaultToFrontFacing(false)
                .labelRetry(R.string.retry)
                .labelConfirm(R.string.confirm)
                .autoRecordWithDelaySec(5)
//                .autoRecordWithDelayMs(5000)
                .countdownMinutes(2.5f)
                .countdownImmediately(true)
                .saveDir(App.baseDir())
                .start(Key.REQUEST_CODE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Key.REQUEST_CODE && resultCode == RESULT_OK) {
            String result = data.getDataString();
            try {
                URL url = new URL(result);
                File file = new File(url.toURI());
                filePath = file.getPath();
                playVideo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void playVideo() throws Exception {
        ivVideo.setDataSource(filePath);
        ivVideo.setLooping(true);
        ivVideo.setVolume(0, 0);
        ivVideo.prepare(mp -> ivVideo.start());
    }

}
