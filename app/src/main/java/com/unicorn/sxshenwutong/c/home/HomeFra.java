package com.unicorn.sxshenwutong.c.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.App;
import com.unicorn.sxshenwutong.a.base.BaseFra;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class HomeFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.fra_home;
    }

    @Override
    protected void init(View rootView) {
        initRv();
        new HomeFetcher(ydbaKey -> {
            HomeResponse homeResponse = new Gson().fromJson(ydbaKey, HomeResponse.class);
            initBanner(homeResponse);
            homeAdapter.setNewData(homeItems(homeResponse));
        }).start();
    }


    // ===================== initRv =====================

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    HomeAdapter homeAdapter = new HomeAdapter();

    private void initRv() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(homeAdapter);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getContext()));
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
    }


    // ===================== homeItems =====================

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


}
