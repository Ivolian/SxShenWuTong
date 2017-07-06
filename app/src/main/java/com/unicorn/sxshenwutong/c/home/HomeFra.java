package com.unicorn.sxshenwutong.c.home;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.a.base.BaseFra;
import com.youth.banner.Banner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindColor;
import butterknife.BindView;

public class HomeFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.fra_home;
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void init(View rootView) {
        s();
        new HomeFetcher(ydbaKey -> {
            HomeResponse homeResponse = new Gson().fromJson(ydbaKey, HomeResponse.class);
            initBanner(homeResponse);
            homeAdapter.setNewData(homeItems(homeResponse));
        }).start();
    }

    HomeAdapter homeAdapter = new HomeAdapter();

    private void s() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(homeAdapter);

        addItemDecoration();
    }
    // ======================= addItemDecoration =======================

    @BindColor(R.color.md_grey_300)
    int grey300;

    private void addItemDecoration() {
        recyclerView.addItemDecoration(new GridItemDecoration.Builder().spanCount(3).spaceSize(1)
                .includeLREdge(false).includeTBEdge(false).drawLREdge(false).drawTBEdge(false)
                .mDivider(new ColorDrawable(grey300)).build());
    }


    private List<HomeItem> homeItems(HomeResponse homeResponse) {
        HomeResponse.MaindataBean mainData = homeResponse.getMaindata();
        return Arrays.asList(
                new HomeItem("审判待办", R.drawable.spdb, mainData.getSpdbajs()),
                new HomeItem("审判待审批", R.drawable.spdsp, mainData.getSpdsp()),
                new HomeItem("审判结案审查", R.drawable.spjasc, mainData.getSpjasc()),
                new HomeItem("执行待办", R.drawable.zxdb, mainData.getZxdbajs()),
                new HomeItem("执行待审批", R.drawable.zxdsp, mainData.getZxdsp()),
                new HomeItem("执行结案审查", R.drawable.zxjasc, mainData.getZxjasc()),
                new HomeItem("已超审限", R.drawable.ycsx, mainData.getCsxwj()),
                new HomeItem("即将超审限", R.drawable.jjcsx, mainData.getJjcsx()),
                new HomeItem("更多", R.drawable.more, -1)
        );
    }


    private void s2() {


    }

    @BindView(R.id.banner)
    Banner banner;

    private void initBanner(HomeResponse homeResponse) {
        List<String> images = homeResponse.getMainpic().stream().map(maindataBean -> App.baseUrl() + maindataBean.getFilepath()).collect(Collectors.toList());
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.start();
    }


}
