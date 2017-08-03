package com.unicorn.sxshenwutong.db.ajws;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.ajws.entity.Ajws;
import com.unicorn.sxshenwutong.db.ajws.entity.AjwsWrapper;

public class AjwsSelectAdapter extends BaseQuickAdapter<AjwsWrapper, BaseViewHolder> {

    Activity activity;


    public AjwsSelectAdapter(Activity activity) {
        super(R.layout.item_ajws_select);
        this.activity = activity;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final AjwsWrapper ajwsWrapper) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());

        Ajws ajws = ajwsWrapper.getAjws();
        viewHolder.setText(R.id.tvXsmc, "文书名称: " + ajws.getXsmc());
        viewHolder.setText(R.id.tvCjsj, "制作时间: " + ajws.getCjsj());

        CheckBox checkBox = viewHolder.getView(R.id.checkbox);
        checkBox.setChecked(ajwsWrapper.isChecked());

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> ajwsWrapper.setChecked(isChecked));
        item.setOnClickListener(v -> checkBox.setChecked(!checkBox.isChecked()));
    }

    private Drawable bg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext, R.color.md_grey_100));
        gradientDrawable.setStroke(1, ContextCompat.getColor(mContext, R.color.md_grey_300));
        return gradientDrawable;
    }

}