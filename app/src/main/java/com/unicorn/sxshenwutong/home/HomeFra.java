package com.unicorn.sxshenwutong.home;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.internal.LinkedTreeMap;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.base.BaseFra;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;
import com.unicorn.sxshenwutong.app.Params;
import com.unicorn.sxshenwutong.app.ParamsInitializer;
import com.unicorn.sxshenwutong.app.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

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

        AppComponentProvider.provide().inject(this);
        s();
        s2();
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

    @Inject
    ParamsInitializer paramsInitializer;

    private void s2() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        paramsInitializer.initParams(params, "getMaindata", parameters);

//        Retrofit retrofit = new RetrofitProvider().provide();
//        LoginService loginService = retrofit.create(LoginService.class);
//        loginService
//                .get(params.toString())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Response>() {
//                    @Override
//                    public void onCompleted() {
//                        Logger.d("");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Logger.d("");
//                    }
//
//                    @Override
//                    public void onNext(Response o) {
//                        onSuccess(o);
//                    }
//                });
    }

    private void copeResponse(Response response) {
        if (response.getCode().equals("000000")) {
            LinkedTreeMap<String, String> parameters = (LinkedTreeMap<String, String>) response.getParameters();
            String ydbaKey = parameters.get("ydbaKey");
            try {
                JSONObject jsonObject = new JSONObject(ydbaKey);


//                String str = jsonObject.getJSONArray("fylist").toString();
//                List<Court> courts =     new Gson().fromJson(str,
//                        new TypeToken<List<Court>>() {
//                        }.getType());
//                courtAdapter.setNewData(courts);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
