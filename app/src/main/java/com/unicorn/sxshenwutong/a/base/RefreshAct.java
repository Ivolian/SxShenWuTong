package com.unicorn.sxshenwutong.a.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;

import butterknife.BindColor;
import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;


public abstract class RefreshAct<T> extends BaseAct {

    protected final int PAGE_SIZE = 10;
    protected int pageNo = 1;
    @BindView(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout swipeRefreshLayout;
    @BindColor(R.color.colorPrimary)
    protected int colorPrimary;
    @BindView(R.id.recyclerView)
    protected RecyclerView recyclerView;

    protected BaseQuickAdapter<T, BaseViewHolder> adapter = getAdapter();

    protected abstract BaseQuickAdapter<T, BaseViewHolder> getAdapter();

    protected abstract Observable<ListResponse<T>> load();

    @Override
    protected void init(Bundle savedInstanceState) {
        initSwipeRefreshLayout();
        initRecycleView();
        swipeRefreshLayout.setRefreshing(true);
        loadFirst();
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeColors(colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(this::loadFirst);
    }

    private void initRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnLoadMoreListener(this::loadNext, recyclerView);
        adapter.setEmptyView(R.layout.empty_view);
    }

    protected void loadFirst() {
        pageNo = 1;
        load().subscribe(new Subscriber<ListResponse<T>>() {
            @Override
            public void onCompleted() {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ListResponse<T> response) {
                adapter.setNewData(response.getRows());
                pageNo++;
            }
        });
    }

    private void loadNext() {
        load().subscribe(new Subscriber<ListResponse<T>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(ListResponse<T> response) {
                adapter.addData(response.getRows());
                adapter.loadMoreComplete();
                pageNo++;

                // 确认是否加载所有数据
                if (adapter.getData().size() >= response.getTotal()) {
                    adapter.loadMoreEnd();
                }
            }
        });
    }

}
