package com.unicorn.sxshenwutong.userType;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.unicorn.sxshenwutong.R;

public class UserTypeAdapter extends BaseQuickAdapter<UserType, BaseViewHolder> {

    public UserTypeAdapter() {
        super(R.layout.item_user_type);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, final UserType userType) {
        LinearLayout item = viewHolder.getView(R.id.item);
        item.setBackground(bg(userType));

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userType.setChecked(!userType.isChecked());
                if (userType.isChecked()) {
                    for (UserType o : getData()) {
                        o.setChecked(o == userType);
                    }
                }
                notifyDataSetChanged();
            }
        });

        viewHolder.setText(R.id.tvUserTypeName, userType.getDmms());

        ImageView ivCheck = viewHolder.getView(R.id.ivCheck);
        Glide.with(mContext).load(userType.isChecked() ? R.drawable.sfsz_form2 : R.drawable.sfsz_form1)
                .into(ivCheck);

    }

    private Drawable bg(UserType userType) {
        int color = ContextCompat.getColor(mContext, userType.isChecked() ?
                R.color.login : R.color.md_grey_400);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(50f);
        gradientDrawable.setStroke(5, color, 12, 4);
        return gradientDrawable;
    }

}