package com.unicorn.sxshenwutong;

import android.app.Activity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding.view.RxView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.lc.NextNodeResponse;
import com.unicorn.sxshenwutong.userList.UserListResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NextNodeDialog {

    private Activity activity;
    private HashMap<String, Object> map;
    private MaterialDialog dialog;
    private String lcid;


    public NextNodeDialog(Activity activity, HashMap<String, Object> map, String lcid) {
        this.activity = activity;
        this.map = map;
        this.lcid = lcid;
    }

    public void show() {
        dialog = new MaterialDialog.Builder(activity)
                .customView(R.layout.custom_view, false)
                .show();
        if (dialog.getCustomView() == null) return;
        ButterKnife.bind(this, dialog.getCustomView());
//        new NextNodeFetcher(lcid,nextNodeResponse -> msNodename.setItems(items(nextNodeResponse))).start();
//        new UserListFetcher(userListResponse -> msUsername.setItems(items(userListResponse))).start();
        RxView.clicks(dialog.getCustomView().findViewById(R.id.tvSubmit))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> submit());
    }





    private void submit() {
        UserListResponse.UserlistBean user = users.get(msUsername.getSelectedIndex());
        map.put("sprid", user.getUserid());
        map.put("sprmc", user.getUsername());
        NextNodeResponse.NextncodesBean node = nodes.get(msNodename.getSelectedIndex());
        map.put("spjdid", node.getNodeid());
        map.put("sprmc", node.getNodename());

//        if (lcid.equals("CQ_DSP_SPGL_SP_AJJZPSP")){
//            new CxbgSubmitter(map, cxbgResponse -> {
//                if (cxbgResponse.isSuccess()) {
//                    dialog.dismiss();
//                    showPrompt();
//                }
//            }).start();
//        }else {
//            new SxbgSubmitter(map, cxbgResponse -> {
//                if (cxbgResponse.isSuccess()) {
//                    dialog.dismiss();
//                    showPrompt();
//                }
//            }).start();
//        }

    }

    private void showPrompt() {
        new MaterialDialog.Builder(activity)
                .title("提示")
                .content("程序变更申请已提交")
                .positiveText("确认")
                .onPositive((dialog1, which) -> RxBus.get().post(RxBusTag.SUBMIT_SUCCESS, new Object()))
                .show();
    }


    private List<NextNodeResponse.NextncodesBean> nodes;

    private List<String> items(NextNodeResponse nextNodeResponse) {
        nodes = nextNodeResponse.getNextncodes();
        List<String> items = new ArrayList<>();
        for (NextNodeResponse.NextncodesBean node : nextNodeResponse.getNextncodes()) {
            items.add(node.getNodename());
        }
        return items;
    }

    private List<UserListResponse.UserlistBean> users;

    private List<String> items(UserListResponse userListResponse) {
        users = userListResponse.getUserlist();
        List<String> items = new ArrayList<>();
        for (UserListResponse.UserlistBean user : userListResponse.getUserlist()) {
            items.add(user.getUsername());
        }
        return items;
    }

    @BindView(R.id.msNodename)
    MaterialSpinner msNodename;
    @BindView(R.id.msUsername)
    MaterialSpinner msUsername;

}
