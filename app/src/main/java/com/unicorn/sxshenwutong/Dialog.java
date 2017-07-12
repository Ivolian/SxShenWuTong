package com.unicorn.sxshenwutong;

import android.app.Activity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.lc.NextNodeFetcher;
import com.unicorn.sxshenwutong.lc.NextNodeResponse;
import com.unicorn.sxshenwutong.userList.UserListFetcher;
import com.unicorn.sxshenwutong.userList.UserListResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dialog {

    @BindView(R.id.msNodename)
    MaterialSpinner msNodename;
    @BindView(R.id.msUsername)
    MaterialSpinner msUsername;

    public void show(Activity activity) {
        MaterialDialog dialog = new MaterialDialog.Builder(activity)
                .customView(R.layout.custom_view, false)
                .show();
        ButterKnife.bind(this, dialog.getCustomView());


        new NextNodeFetcher(new Callback<NextNodeResponse>() {
            @Override
            public void onSuccess(NextNodeResponse nextNodeResponse) {
                msNodename.setItems(items(nextNodeResponse));
            }
        }).start();

        new UserListFetcher(new Callback<UserListResponse>() {
            @Override
            public void onSuccess(UserListResponse userListResponse) {
                msUsername.setItems(items(userListResponse));
            }
        }).start();

    }

    private List<String> items(NextNodeResponse nextNodeResponse) {
        List<String> items = new ArrayList<>();
        for (NextNodeResponse.NextncodesBean node : nextNodeResponse.getNextncodes()) {
            items.add(node.getNodename());
        }
        return items;
    }

    private List<String> items(UserListResponse userListResponse) {
        List<String> items = new ArrayList<>();
        for (UserListResponse.UserlistBean user : userListResponse.getUserlist()) {
            items.add(user.getUsername());
        }
        return items;
    }

}
