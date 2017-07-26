package com.unicorn.sxshenwutong.d.ajws;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.d.ajws.entity.Ajws;

public class AjwsAdapter extends BaseQuickAdapter<Ajws, BaseViewHolder> {

    Activity activity;

    public AjwsAdapter(Activity activity) {
        super(R.layout.item_ajws);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajws ajws) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());

        viewHolder.setText(R.id.tvXsmc, "文书名称: " + ajws.getXsmc());
        viewHolder.setText(R.id.tvCjsj, "制作时间: " + ajws.getCjsj());

        item.setOnClickListener(v -> new AjwsHelper(activity, ajws).viewAjws());
    }

    private Drawable bg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(mContext, R.color.md_grey_300));
        return gradientDrawable;
    }

}