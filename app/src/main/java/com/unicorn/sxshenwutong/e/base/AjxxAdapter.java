package com.unicorn.sxshenwutong.e.base;

import android.support.annotation.LayoutRes;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.base.BaseRenderer;
import com.unicorn.sxshenwutong.d.spdb.Ajxx;

public abstract class AjxxAdapter extends BaseQuickAdapter<Ajxx, BaseViewHolder> {

    public AjxxAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    abstract protected BaseRenderer<Ajxx> getRenderer(BaseViewHolder viewHolder, Ajxx ajxx);

    @Override
    protected void convert(BaseViewHolder viewHolder, Ajxx ajxx) {
        LinearLayout item = viewHolder.getView(R.id.item);
//        item.setBackground(BaseHelper.bg(mContext));
        getRenderer(viewHolder, ajxx).render();
    }

}
