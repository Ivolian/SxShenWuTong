package com.unicorn.sxshenwutong.list;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;

public class ListAdapter extends BaseQuickAdapter<Model, BaseViewHolder> {

    public ListAdapter() {
        super(R.layout.item_list);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final Model model) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg());
        viewHolder.setText(R.id.tvText,model.getAhqc());
    }

    private Drawable bg(){
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(mContext,R.color.md_grey_100));
        gradientDrawable.setStroke(1,ContextCompat.getColor(mContext,R.color.md_grey_300));
        return  gradientDrawable;
    }


}