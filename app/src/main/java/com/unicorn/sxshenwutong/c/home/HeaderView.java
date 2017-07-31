package com.unicorn.sxshenwutong.c.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.c.home.entity.HomeItem;
import com.unicorn.sxshenwutong.c.home.entity.HomeResponse;
import com.unicorn.sxshenwutong.c.home.other.GlideImageLoader;
import com.youth.banner.Banner;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
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

    private List<HomeItem> homeItems2(HomeResponse homeResponse) {
        HomeResponse.MaindataBean mainData = homeResponse.getMaindata();
        return Arrays.asList(
                new HomeItem("执行收案未立", mainData.getZxsawl(), "zxsawllist"),
                new HomeItem("审判收案未立", mainData.getSpsawl(), "spsawllist"),
                new HomeItem("执行立案未移送", mainData.getZxlawys(), "zxlawyslist"),
                new HomeItem("审判立案未移送", mainData.getSplawys(), "splawyslist")
        );
    }


}
