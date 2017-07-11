package com.unicorn.sxshenwutong.b.court;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;

import com.github.promeg.pinyinhelper.Pinyin;
import com.google.gson.Gson;
import com.hwangjr.rxbus.RxBus;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.b.court.entity.Court;
import com.unicorn.sxshenwutong.b.court.entity.CourtResponse;
import com.unicorn.sxshenwutong.a.dagger.AppComponentProvider;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import me.yokeyword.indexablerv.IndexableLayout;

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
    CourtAdapter courtAdapter;

    private void initRv() {
        indexableLayout.setLayoutManager(new LinearLayoutManager(this));
        indexableLayout.setCompareMode(IndexableLayout.MODE_ALL_LETTERS);
        setCenterOverlay();
        indexableLayout.setAdapter(courtAdapter);
        addItemDecoration();
        setOnItemContentClickListener();
        getCourts();
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
        courtAdapter.setOnItemContentClickListener((view, originalPosition, i1, court) -> {
            if (originalPosition >= 0) {
                RxBus.get().post(RxBusTag.SELECT_COURT, court);
                finish();
            }
        });
    }


    // ===================== getCourts =====================

    @Inject
    Gson gson;

    private void getCourts() {
        new CourtFetcher(ydbaKey -> {
            CourtResponse courtResponse = gson.fromJson(ydbaKey, CourtResponse.class);
            for (Court court : courtResponse.getFylist()) {
                court.setPinyin(Pinyin.toPinyin(court.getFyjc(), ""));
            }
            courtAdapter.setDatas(courtResponse.getFylist());
        }).start();
    }

}
