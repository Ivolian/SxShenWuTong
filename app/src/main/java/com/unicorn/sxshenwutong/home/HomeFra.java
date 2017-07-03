package com.unicorn.sxshenwutong.home;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.base.BaseFra;

import java.util.Arrays;
import java.util.List;

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
    }

    HomeAdapter homeAdapter = new HomeAdapter();

    private void s() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setNewData(items());
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



    private List<HomeItem> items(){
        return Arrays.asList(
                new HomeItem("审判待办",R.drawable.spdb),
                new HomeItem("审判待审批",R.drawable.spdsp),
                new HomeItem("审判结案审查",R.drawable.spjasc),
                new HomeItem("执行待办",R.drawable.zxdb),
                new HomeItem("执行待审批",R.drawable.zxdsp),
                new HomeItem("执行结案审查",R.drawable.zxjasc),
                new HomeItem("已超审限",R.drawable.ycsx),
                new HomeItem("即将超审限",R.drawable.jjcsx),
                new HomeItem("更多",R.drawable.more)
        );
    }

}
