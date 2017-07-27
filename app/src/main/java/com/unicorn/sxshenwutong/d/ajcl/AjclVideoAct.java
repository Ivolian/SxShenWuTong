package com.unicorn.sxshenwutong.d.ajcl;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialcamera.MaterialCamera;
import com.blankj.utilcode.util.ToastUtils;
import com.example.mylibrary.http.UploadDownloadlistener;
import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import pocketknife.BindExtra;

public class AjclVideoAct extends BaseAct {

    @Override
    protected void init(Bundle savedInstanceState)   {
        super.init(savedInstanceState);

        clickBack();
        RxView.clicks(findViewById(R.id.ivVideo)).subscribe(aVoid -> {

            new MaterialCamera(this)
                    .countdownMinutes(2.5f)
                    .countdownImmediately(true)
                    .saveDir(App.baseDir())
                    .start(2333);
        });


        try {
            ivVideo.setRawData(R.raw.landscape_sample);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ivVideo.setVolume(0, 0);
        ivVideo.setLooping(true);
        try {
            ivVideo.prepare(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    ivVideo.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


        RxView.clicks(findViewById(R.id.tvSave)).subscribe(aVoid -> {
            if (path == null) {
                ToastUtils.showShort("请添加录像");
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Received recording or error from MaterialCamera
        if (requestCode == 2333) {

            if (resultCode == RESULT_OK) {

                Toast.makeText(this, "Saved to: " + data.getDataString(), Toast.LENGTH_LONG).show();

//                jcVideoPlayerStandard.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");

            } else if(data != null) {
                Exception e = (Exception) data.getSerializableExtra(MaterialCamera.ERROR_EXTRA);
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @BindExtra(Key.AJBS)
    String ajbs;

    @BindView(R.id.ivVideo)
    ScalableVideoView ivVideo;



    String path;

    @BindView(R.id.etFileName)
    EditText etFileName;

    @BindView(R.id.etMs)
    EditText etMs;


    @Override
    protected int layoutResId() {
        return R.layout.act_ajcl_video;
    }
}
