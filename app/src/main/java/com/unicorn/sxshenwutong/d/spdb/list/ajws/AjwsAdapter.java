package com.unicorn.sxshenwutong.d.spdb.list.ajws;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.constant.Key;
import com.unicorn.sxshenwutong.d.spdb.list.ajws.entity.Ajws;
import com.unicorn.sxshenwutong.d.spdb.wssp.WsspSqAct;

public class AjwsAdapter extends BaseQuickAdapter<Ajws, BaseViewHolder> {

    Activity activity;
    String ajbs;

    public String getAjbs() {
        return ajbs;
    }

    public void setAjbs(String ajbs) {
        this.ajbs = ajbs;
    }

    public AjwsAdapter(Activity activity) {
        super(R.layout.item_ajws);
        this.activity = activity;
    }




    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajws ajws) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());

        viewHolder.setText(R.id.tvXsmc, "名称: " + ajws.getXsmc());
        viewHolder.setText(R.id.tvCjsj, "制作时间: " + ajws.getCjsj());

        TextView tvView = viewHolder.getView(R.id.tvView);
        tvView.setOnClickListener(v -> new AjwsHelper(activity, ajws).viewAjws());
        TextView tvWssp = viewHolder.getView(R.id.tvWssp);
        tvWssp.setOnClickListener(v -> {
            Intent intent = new Intent(activity, WsspSqAct.class);
            intent.putExtra(Key.AJBS, ajbs);
            activity.startActivity(intent);
        });
    }

    private Drawable bg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(mContext, R.color.md_grey_300));
        return gradientDrawable;
    }

}