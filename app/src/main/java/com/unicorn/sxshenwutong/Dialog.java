package com.unicorn.sxshenwutong;

import android.app.Activity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jakewharton.rxbinding.view.RxView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.a.app.Callback;
import com.unicorn.sxshenwutong.lc.NextNodeFetcher;
import com.unicorn.sxshenwutong.lc.NextNodeResponse;
import com.unicorn.sxshenwutong.userList.UserListFetcher;
import com.unicorn.sxshenwutong.userList.UserListResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class Dialog {

    @BindView(R.id.msNodename)
    MaterialSpinner msNodename;
    @BindView(R.id.msUsername)
    MaterialSpinner msUsername;


        List<UserListResponse.UserlistBean> users;
    List<NextNodeResponse.NextncodesBean> nodes;
    public void show(Activity activity, HashMap<String,Object> map) {
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


        RxView.clicks(dialog.getCustomView().findViewById(R.id.tvSubmit))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        UserListResponse.UserlistBean user = users.get( msUsername.getSelectedIndex());
                        map.put("sprid",user.getUserid());
                        map.put("sprmc",user.getUsername());
                        NextNodeResponse.NextncodesBean node = nodes.get( msNodename.getSelectedIndex());

                        map.put("spjdid",node.getNodeid());
                        map.put("sprmc",node.getNodename());

                        new CxbgFetcher(map, new Callback<Object>() {
                            @Override
                            public void onSuccess(Object o) {

                            }
                        }).start();
                    }
                });
    }

    private List<String> items(NextNodeResponse nextNodeResponse) {
        nodes = nextNodeResponse.getNextncodes();
        List<String> items = new ArrayList<>();
        for (NextNodeResponse.NextncodesBean node : nextNodeResponse.getNextncodes()) {
            items.add(node.getNodename());
        }
        return items;
    }

    private List<String> items(UserListResponse userListResponse) {
        users = userListResponse.getUserlist();
        List<String> items = new ArrayList<>();
        for (UserListResponse.UserlistBean user : userListResponse.getUserlist()) {
            items.add(user.getUsername());
        }
        return items;
    }

}
