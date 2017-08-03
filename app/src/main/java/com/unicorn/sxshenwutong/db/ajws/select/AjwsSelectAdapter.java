package com.unicorn.sxshenwutong.db.ajws.select;

import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.ajws.ajws.entity.Ajws;
import com.unicorn.sxshenwutong.db.ajws.select.entity.AjwsWrapper;

class AjwsSelectAdapter extends BaseQuickAdapter<AjwsWrapper, BaseViewHolder> {

    AjwsSelectAdapter() {
        super(R.layout.item_ajws_select);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final AjwsWrapper ajwsWrapper) {
        Ajws ajws = ajwsWrapper.getAjws();
        viewHolder.setText(R.id.tvXsmc, ajws.getXsmc());
        viewHolder.setText(R.id.tvCjsj, ajws.getCjsj());

        CheckBox checkBox = viewHolder.getView(R.id.checkBox);
        checkBox.setChecked(ajwsWrapper.isChecked());
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> ajwsWrapper.setChecked(isChecked));
//        viewHolder.setOnClickListener(R.id.item, v -> checkBox.setChecked(!checkBox.isChecked()));
    }

}