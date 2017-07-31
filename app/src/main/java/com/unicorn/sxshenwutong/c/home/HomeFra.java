package com.unicorn.sxshenwutong.c.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseFra;
import com.unicorn.sxshenwutong.c.home.entity.HomeItem;
import com.unicorn.sxshenwutong.c.home.entity.HomeResponse;
import com.unicorn.sxshenwutong.c.home.network.HomeFetcher;
import com.unicorn.sxshenwutong.c.home.other.DividerGridItemDecoration;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class HomeFra extends BaseFra {

    @Override
    protected int layoutResId() {
        return R.layout.fra_home;
    }

    @Override
    protected void init(View rootView) {
        initRv();
        fetchHomeInfo();
    }


    // ===================== initRv =====================

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    HomeAdapter homeAdapter;

    HeaderView headerView;

    private void initRv() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(homeAdapter = new HomeAdapter());
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getContext()));
        homeAdapter.addHeaderView(headerView = new HeaderView(getActivity(), null));
    }


    // ===================== homeItems =====================

    @Override
    public void onSupportVisible() {
        fetchHomeInfo();
    }

    private void fetchHomeInfo() {
        new HomeFetcher().start().subscribe(new Subscriber<HomeResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HomeResponse homeResponse) {
                headerView.init(homeResponse);
                homeAdapter.setNewData(homeItems(homeResponse));
            }
        });
    }

    private List<HomeItem> homeItems(HomeResponse homeResponse) {
        HomeResponse.MaindataBean mainData = homeResponse.getMaindata();
        return Arrays.asList(
                new HomeItem("审判待办", R.drawable.spdb, mainData.getSpdbajs(), "spdblist"),
                new HomeItem("审判待审批", R.drawable.spdsp, mainData.getSpdsp(), "spdsplist"),
                new HomeItem("审判结案审查", R.drawable.spjasc, mainData.getSpjasc(), "spjasclist"),
                new HomeItem("执行待办", R.drawable.zxdb, mainData.getZxdbajs(), "zxdblist"),
                new HomeItem("执行待审批", R.drawable.zxdsp, mainData.getZxdsp(), "zxdsplist"),
                new HomeItem("执行结案审查", R.drawable.zxjasc, mainData.getZxjasc(), "zxjasclist"),
                new HomeItem("已超审限", R.drawable.ycsx, mainData.getCsxwj(), "ycsxlist"),
                new HomeItem("即将超审限", R.drawable.jjcsx, mainData.getJjcsx(), "jjcsxlist"),
                new HomeItem("当天开庭", R.drawable.more, mainData.getKtajs(), "dtktlist")
        );
    }



}
