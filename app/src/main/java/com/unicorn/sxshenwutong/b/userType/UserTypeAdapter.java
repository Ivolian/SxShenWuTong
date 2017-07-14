package com.unicorn.sxshenwutong.b.userType;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.b.userType.entity.UserTypeWrapper;
import com.unicorn.sxshenwutong.R;

public class UserTypeAdapter extends BaseQuickAdapter<UserTypeWrapper, BaseViewHolder> {

    public UserTypeAdapter() {
        super(R.layout.item_user_type);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final UserTypeWrapper userType) {
        boolean checked = userType.isChecked();
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg(checked));

        item.setOnClickListener(v -> {
            userType.setChecked(!checked);
            if (!checked) {
                for (UserTypeWrapper o : getData()) {
                    o.setChecked(o == userType);
                }
            }
            notifyDataSetChanged();
        });

        viewHolder.setText(R.id.tvUserTypeName, userType.getCode().getDmms());
        ImageView ivCheck = viewHolder.getView(R.id.ivCheck);
        Glide.with(mContext).load(checked ? R.drawable.sfsz_form2 : R.drawable.sfsz_form1).into(ivCheck);
    }

    private Drawable bg(boolean checked) {
        int color = ContextCompat.getColor(mContext, checked ? R.color.login : R.color.md_grey_400);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(50f);
        gradientDrawable.setStroke(5, color, 12, 4);
        return gradientDrawable;
    }

}