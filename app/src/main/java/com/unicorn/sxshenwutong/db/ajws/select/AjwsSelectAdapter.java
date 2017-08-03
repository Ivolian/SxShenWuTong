package com.unicorn.sxshenwutong.db.ajws.select;

import android.util.SparseBooleanArray;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.db.ajws.ajws.entity.Ajws;

import java.util.ArrayList;
import java.util.List;


class AjwsSelectAdapter extends BaseQuickAdapter<Ajws, BaseViewHolder> {

    AjwsSelectAdapter() {
        super(R.layout.item_ajws_select);
    }

    private SparseBooleanArray selectedPositions = new SparseBooleanArray();

    @Override
    protected void convert(BaseViewHolder viewHolder, final Ajws ajws) {
        viewHolder.setText(R.id.tvXsmc, ajws.getXsmc());
        viewHolder.setText(R.id.tvCjsj, ajws.getCjsj());

        CheckBox checkBox = viewHolder.getView(R.id.checkBox);
        checkBox.setChecked(selectedPositions.get(viewHolder.getAdapterPosition()));
        // important!
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> selectedPositions.put(viewHolder.getAdapterPosition(), isChecked));
        viewHolder.setOnClickListener(R.id.item, v -> checkBox.setChecked(!checkBox.isChecked()));
    }

    List<Ajws> getSelectedAjwsList() {
        List<Ajws> list = new ArrayList<>();
        for (Ajws ajws : getData()) {
            int pos = getData().indexOf(ajws);
            if (selectedPositions.get(pos)) {
                list.add(ajws);
            }
        }
        return list;
    }

}