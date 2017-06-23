package com.unicorn.sxshenwutong;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.View;

import com.github.promeg.pinyinhelper.Pinyin;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.hwangjr.rxbus.RxBus;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.base.BaseAct;
import com.unicorn.sxshenwutong.code.CodeHelper;
import com.unicorn.sxshenwutong.constant.RxBusTag;
import com.unicorn.sxshenwutong.court.Court;
import com.unicorn.sxshenwutong.court.data.CourtAdapter2;
import com.unicorn.sxshenwutong.court.data.CourtService;
import com.unicorn.sxshenwutong.dagger.AppComponentProvider;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CourtAct extends BaseAct {

    @Override
    protected void inject() {
        AppComponentProvider.provide().inject(this);
    }

    @Override
    protected int layoutResId() {
        return R.layout.act_court;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initRv();
    }


    // ===================== initRv =====================

    @BindView(R.id.indexableLayout)
    IndexableLayout indexableLayout;

    @Inject
    CourtAdapter2 courtAdapter;

    @Inject
    CodeHelper codeHelper;

    private void initRv() {

        indexableLayout.setLayoutManager(new LinearLayoutManager(this));
        indexableLayout.setCompareMode(IndexableLayout.MODE_ALL_LETTERS);
        setCenterOverlay();
        indexableLayout.setAdapter(courtAdapter);
        addItemDecoration();
        setOnItemContentClickListener();

codeHelper.s();
        // 获取法院
        getCourt();
    }

    /**
     * setCenterOverlay.
     */
    @BindColor(R.color.colorPrimary)
    int colorPrimary;

    private void setCenterOverlay() {
        indexableLayout.setOverlayStyle_Center();
        indexableLayout.getmCenterOverlay().setBackgroundColor(Color.TRANSPARENT);
        indexableLayout.getmCenterOverlay().setTextColor(colorPrimary);
        indexableLayout.getmCenterOverlay().setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50);
    }

    /**
     * addItemDecoration.
     */
    @BindColor(R.color.md_grey_300)
    int grey300;

    private void addItemDecoration() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(1);
        paint.setColor(grey300);
        HorizontalDividerItemDecoration itemDecoration = new HorizontalDividerItemDecoration.Builder(this).paint(paint).build();
        indexableLayout.getRecyclerView().addItemDecoration(itemDecoration);
    }

    /**
     * setOnItemContentClickListener.
     */
    private void setOnItemContentClickListener() {
        courtAdapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<Court>() {
            @Override
            public void onItemClick(View view, int originalPosition, int i1, Court court) {
                if (originalPosition >= 0) {
                    RxBus.get().post(RxBusTag.SELECT_COURT, court);
                    finish();
                }
            }
        });
    }


    // ===================== getCourt =====================

    @Inject
    ParamsHelper paramsHelper;

    @Inject
    CourtService courtService;

    private void getCourt() {
        Params params = new Params();
        paramsHelper.initParams(params, "getFyList", new HashMap<String, Object>());
        courtService.getCourt(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("");
                    }

                    @Override
                    public void onNext(Response o) {
                        CourtAct.this.copeResponse(o);
                    }
                });
    }


    private void copeResponse(Response response) {
        if (response.getCode().equals("000000")) {
            LinkedTreeMap<String, String> parameters = (LinkedTreeMap<String, String>) response.getParameters();
            String ydbaKey = parameters.get("ydbaKey");
            try {
                JSONObject jsonObject = new JSONObject(ydbaKey);
                String str = jsonObject.getJSONArray("fylist").toString();
                List<Court> courts = new Gson().fromJson(str,
                        new TypeToken<List<Court>>() {
                        }.getType());

                for (Court court : courts) {
                    court.setPinyin(Pinyin.toPinyin(court.getFyjc(), ""));
                }
                courtAdapter.setDatas(courts);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
