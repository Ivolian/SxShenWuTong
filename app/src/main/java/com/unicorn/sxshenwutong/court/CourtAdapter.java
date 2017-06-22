package com.unicorn.sxshenwutong.court;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;

public class CourtAdapter extends BaseQuickAdapter<Court, BaseViewHolder> {

    public CourtAdapter() {
        super(R.layout.item_court);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, Court court) {
        viewHolder.setText(R.id.tvCourtName, court.getDmms());
    }

}