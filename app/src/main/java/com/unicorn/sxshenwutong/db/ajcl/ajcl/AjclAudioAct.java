package com.unicorn.sxshenwutong.db.ajcl.ajcl;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.db.ajcl.ajcl.base.AjclAct;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import cafe.adriel.androidaudiorecorder.AndroidAudioRecorder;

public class AjclAudioAct extends AjclAct {

    @Override
    protected int layoutResId() {
        return R.layout.act_ajcl_audio;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clickPhoto();
    }

    MediaPlayer mediaPlayer = new MediaPlayer();

    @BindView(R.id.tvPlay)
    TextView tvPlay;

    private void clickPhoto() {
        RxView.clicks(findViewById(R.id.tvPlay))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    String text = tvPlay.getText().toString().trim();
                    switch (text) {
                        case "录音":
                            startRecord();
                            break;
                        case "播放":
                            playVideo();
                            break;
                    }

                });
    }

    private void startRecord() {
        File file = new File(App.baseDir(), "test.wav");
        int color = getResources().getColor(R.color.colorPrimaryDark);
        filePath = file.getPath();
        AndroidAudioRecorder.with(this)
                // Required
                .setFilePath(filePath)
                .setColor(color)
                .setRequestCode(Key.REQUEST_CODE)

//                            // Optional
//                            .setSource(AudioSource.MIC)
//                            .setChannel(AudioChannel.STEREO)
//                            .setSampleRate(AudioSampleRate.HZ_48000)
//                            .setAutoStart(true)
//                            .setKeepDisplayOn(true)

                // Start recording
                .record();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Key.REQUEST_CODE && resultCode == RESULT_OK) {
            playVideo();
        }
    }

    private void playVideo() {
        tvPlay.setText("播放录音中");
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(mp -> mediaPlayer.start());
            mediaPlayer.setOnCompletionListener(mp -> tvPlay.setText("播放"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
