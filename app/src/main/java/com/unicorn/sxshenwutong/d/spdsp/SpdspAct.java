package com.unicorn.sxshenwutong.d.spdsp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseAct;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;

import java.util.HashMap;

import butterknife.BindColor;
import butterknife.BindView;
import pocketknife.BindExtra;

abstract public class SpdspAct extends BaseAct {

    @BindExtra(Key.AJBS)
    String ajbs;
    @BindExtra(Key.SPID)
    String spid;
    @BindExtra(Key.LCID)
    String lcid;

    protected Spdsp spdsp;

    @Override
    protected void init(Bundle savedInstanceState) {
        clickBack();
        fetchSpdsp();
    }

    private void fetchSpdsp() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Key.AJBS, ajbs);
        map.put(Key.SPID, spid);
        map.put(Key.LCID, lcid);
        new SpdspFetcher(map).start().subscribe(o -> {
            spdsp = o;
            s();
            t();
            afterFetchSpdsp();
        });
    }


    @BindView(R.id.tvSpyjLabel)
    TextView tvSpyjLabel;

    @BindView(R.id.etSpyj)
    protected EditText etSpyj;

    private void t(){
        Spdsp.DblbxxBean dblbxxBean = spdsp.getDblbxx();
        tvSpyjLabel.setText(dblbxxBean.getNodename());
    }


    @BindView(R.id.llSpyjContainer)
    LinearLayout llSpyjContainer;



    @BindColor(R.color.md_grey_100)
    int md_grey_100;


    private void s(){
        for(Spdsp.SpyjlistBean spyj:spdsp.getSpyjlist()){
            addSpyj(spyj);
        }
    }



    private void addSpyj(Spdsp.SpyjlistBean spyj){
        LinearLayout linearLayout =new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams lpLabel = new LinearLayout.LayoutParams(ConvertUtils.dp2px(100), ViewGroup.LayoutParams.MATCH_PARENT);
        lpLabel.setMargins(0,0,1,0);
        TextView tvLabel  = new TextView(this);
        tvLabel.setBackgroundColor(md_grey_100);
        tvLabel.setGravity(Gravity.CENTER);
        tvLabel.setText(spyj.getNodename());
        tvLabel.setTextColor(Color.BLACK);
        linearLayout.addView(tvLabel,lpLabel);

        LinearLayout.LayoutParams lpSpyj = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1);
        TextView tvSpyj  = new TextView(this);
        tvSpyj.setBackgroundColor(Color.WHITE);
        tvSpyj.setGravity(Gravity.CENTER_VERTICAL);
        tvSpyj.setPadding(ConvertUtils.dp2px(16),0,0,0);
        tvSpyj.setTextColor(Color.BLACK);
        tvSpyj.setText(spyj.getSpyj());
        linearLayout.addView(tvSpyj,lpSpyj);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ConvertUtils.dp2px(48));
        layoutParams.setMargins(0,1,0,0);
        llSpyjContainer.addView(linearLayout,layoutParams);
    }

    abstract protected void afterFetchSpdsp();

    // ===================== onSubmitSuccess =====================

    @Override
    protected boolean useRxBus() {
        return true;
    }

    @Subscribe(tags = {@Tag(RxBusTag.SUBMIT_SUCCESS)})
    public void onSubmitSuccess(Object o) {
        finish();
    }
}


