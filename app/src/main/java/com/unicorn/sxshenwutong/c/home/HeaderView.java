package com.unicorn.sxshenwutong.c.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.klinker.android.link_builder.Link;
import com.klinker.android.link_builder.LinkBuilder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.c.home.entity.HomeItem;
import com.unicorn.sxshenwutong.c.home.entity.HomeResponse;
import com.unicorn.sxshenwutong.c.home.other.GlideImageLoader;
import com.unicorn.sxshenwutong.e.lawys.LawysListAct;
import com.unicorn.sxshenwutong.e.sawl.SawlListAct;
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
    }

    public void init(HomeResponse homeResponse) {
        initBanner(homeResponse);
        initMarquee(homeResponse);
    }


    // ===================== banner =====================

    @BindView(R.id.banner)
    Banner banner;

    private void initBanner(HomeResponse homeResponse) {
        List<String> images = new ArrayList<>();
        for (HomeResponse.MainpicBean mainpicBean : homeResponse.getMainpic()) {
            images.add(App.baseUrl() + mainpicBean.getFilepath());
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.start();
        initMarquee(homeResponse);
    }


    // ===================== banner =====================

    @BindView(R.id.tvMarquee)
    TextView tvMarquee;

    private void initMarquee(HomeResponse homeResponse) {
        String text = "";
        List<Link> linkList = new ArrayList<>();
        for (HomeItem homeItem : homeItems(homeResponse)) {
            if (homeItem.getCount() != 0) {
                text += (" " + homeItem.getDisplay() + " ");
                linkList.add(createLink(homeItem));
            }
        }
        tvMarquee.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tvMarquee.setText(text);
        if (linkList.size() != 0) {
            LinkBuilder.on(tvMarquee)
                    .addLinks(linkList)
                    .build();
        }
    }

    private Link createLink(HomeItem homeItem) {
        return new Link(homeItem.getDisplay())
                .setTextColor(Color.BLACK)
                .setUnderlined(false)
                .setOnClickListener(clickedText -> {
                    String title = homeItem.getTitle();
                    Intent intent = new Intent(getContext(), title.equals("收案未立") ? SawlListAct.class : LawysListAct.class);
                    intent.putExtra(Key.TITLE, homeItem.getTitle());
                    intent.putExtra(Key.LBTYPE, homeItem.getLbtype());
                    getContext().startActivity(intent);
                });
    }

    private List<HomeItem> homeItems(HomeResponse homeResponse) {
        HomeResponse.MaindataBean mainData = homeResponse.getMaindata();
        return Arrays.asList(
                new HomeItem("执行收案未立", mainData.getZxsawl(), "zxsawllist"),
                new HomeItem("审判收案未立", mainData.getSpsawl(), "spsawllist"),
                new HomeItem("执行立案未移送", mainData.getZxlawys(), "zxlawyslist"),
                new HomeItem("审判立案未移送", mainData.getSplawys(), "splawyslist")
        );
    }


}
