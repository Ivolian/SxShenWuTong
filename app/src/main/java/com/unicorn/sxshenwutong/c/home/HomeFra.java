package com.unicorn.sxshenwutong.c.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.a.base.BaseFra;
import com.unicorn.sxshenwutong.c.home.entity.HomeResponse;
import com.unicorn.sxshenwutong.c.home.network.HomeFetcher;
import com.unicorn.sxshenwutong.c.home.other.DividerGridItemDecoration;

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
                Logger.e("");
            }

            @Override
            public void onNext(HomeResponse homeResponse) {
                new HomeHelper().refreshHomeItem(homeResponse);
                headerView.init(homeResponse);
                homeAdapter.setNewData(Global.getHomeItemListBottom());
            }
        });
    }






}
