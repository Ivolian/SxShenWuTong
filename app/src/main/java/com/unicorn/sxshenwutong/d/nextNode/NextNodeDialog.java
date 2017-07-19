package com.unicorn.sxshenwutong.d.nextNode;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding.view.RxView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.code.entity.Code;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.SimpleSubmitter;

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
    private SimpleSubmitter simpleSubmitter;
    private boolean showSp = false;

    public NextNodeDialog(Activity activity, String lcid, SimpleSubmitter simpleSubmitter) {
        this.activity = activity;
        this.map = simpleSubmitter.getMap();
        this.lcid = lcid;
        this.simpleSubmitter = simpleSubmitter;
    }

    public NextNodeDialog(Activity activity, String lcid, SimpleSubmitter simpleSubmitter, boolean showSp) {
        this.activity = activity;
        this.map = simpleSubmitter.getMap();
        this.lcid = lcid;
        this.simpleSubmitter = simpleSubmitter;
        this.showSp = showSp;
    }

    List<Code> spList;

    public void show() {
        dialog = new MaterialDialog.Builder(activity)
                .customView(R.layout.custom_view, false)
                .show();
        if (dialog.getCustomView() == null) return;
        ButterKnife.bind(this, dialog.getCustomView());
        msNodename.setOnItemSelectedListener((view, position, id, item) -> updateSp(nodes.get(position).getNodename()));
        new NextNodeFetcher(lcid).start().subscribe(nextNodeResponse -> {
            msNodename.setItems(items(nextNodeResponse));
            updateSp(nodes.get(0).getNodename());
        });
        new UserListFetcher().start().subscribe(userListResponse -> msUsername.setItems(items(userListResponse)));

        RxView.clicks(dialog.getCustomView().findViewById(R.id.tvSubmit))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> submit());
    }

    private void updateSp(String item){
        if (showSp) {
            llSp.setVisibility(View.VISIBLE);
            spList = new ArrayList<>();
            if (item.contains("至拟稿人") || item.equals("结束")) {
                spList.add(new Code("commitToEnd", "同意并结束"));
            }
            spList.add(new Code("commitToContinue", "同意并继续"));
            spList.add(new Code("backToUpdate", "退回并整理"));
            spList.add(new Code("backToEnd", "退回并结束"));
            msSp.setItems(items(spList));
        }
    }




    private void submit() {
        UserListResponse.UserlistBean user = users.get(msUsername.getSelectedIndex());
        map.put("sprid", user.getUserid());
        map.put("sprmc", user.getUsername());
        NextNodeResponse.NextncodesBean node = nodes.get(msNodename.getSelectedIndex());
        map.put("spjdid", node.getNodeid());
        map.put("spjdmc", node.getNodename());

        if (showSp) {
            Code sp = spList.get(msSp.getSelectedIndex());
            map.put("nextParamsVal", sp.getDm());
        }
        simpleSubmitter.start().subscribe(simpleResponse -> {
            if (simpleResponse.isSuccess()) {
                dialog.dismiss();
                showPrompt();
            }
        });
    }

    private void showPrompt() {
        new MaterialDialog.Builder(activity)
                .title("提示")
                .content("提交成功")
                .positiveText("确认")
                .onPositive((dialog1, which) -> RxBus.get().post(RxBusTag.SUBMIT_SUCCESS, new Object()))
                .show();
    }

    private List<String> items(List<Code> codeList) {
        List<String> items = new ArrayList<>();
        for (Code code : codeList) {
            items.add(code.getDmms());
        }
        return items;
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
    @BindView(R.id.msSp)
    MaterialSpinner msSp;
    @BindView(R.id.llSp)
    LinearLayout llSp;

}
