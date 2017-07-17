package com.unicorn.sxshenwutong.c.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.c.home.entity.HomeResponse;
import com.unicorn.sxshenwutong.c.home.other.GlideImageLoader;
import com.youth.banner.Banner;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeaderView extends PercentLinearLayout {

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.header_view_home, this, true);
        ButterKnife.bind(this);
        tvM.setSelected(true);
    }

    // ===================== banner =====================

    @BindView(R.id.tvM)
    TextView tvM;

    @BindView(R.id.banner)
    Banner banner;

    public void initBanner(HomeResponse homeResponse) {
        List<String> images = new ArrayList<>();
        for (HomeResponse.MainpicBean mainpicBean : homeResponse.getMainpic()) {
            images.add(App.baseUrl() + mainpicBean.getFilepath());
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.start();
    }


}
