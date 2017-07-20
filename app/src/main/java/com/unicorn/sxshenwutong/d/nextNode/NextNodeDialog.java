package com.unicorn.sxshenwutong.d.nextNode;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.hwangjr.rxbus.RxBus;
import com.jakewharton.rxbinding.view.RxView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.SimpleSubmitter;
import com.unicorn.sxshenwutong.a.constant.RxBusTag;
import com.unicorn.sxshenwutong.d.nextNode.entity.NextNodeResponse;
import com.unicorn.sxshenwutong.d.nextNode.entity.NextUserListResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;

public class NextNodeDialog {

    private Activity activity;
    private String lcid;
    private SimpleSubmitter simpleSubmitter;
    private boolean showSpOption = false;
    private MaterialDialog dialog;
    private String sqr;

    public String getSqr() {
        return sqr;
    }

    public void setSqr(String sqr) {
        this.sqr = sqr;
    }

    public NextNodeDialog(Activity activity, String lcid, SimpleSubmitter simpleSubmitter) {
        this.activity = activity;
        this.lcid = lcid;
        this.simpleSubmitter = simpleSubmitter;
    }

    public NextNodeDialog(Activity activity, String lcid, SimpleSubmitter simpleSubmitter, boolean showSpOption) {
        this.activity = activity;
        this.lcid = lcid;
        this.simpleSubmitter = simpleSubmitter;
        this.showSpOption = showSpOption;
    }


    public void show() {
        dialog = new MaterialDialog.Builder(activity)
                .customView(R.layout.custom_view, false)
                .show();
        if (dialog.getCustomView() == null) return;
        ButterKnife.bind(this, dialog.getCustomView());


        msNodename.setOnItemSelectedListener((view, position, id, item) -> {
            NextNodeResponse.NextncodesBean node = nodes.get(position);
            fetchSpOption(node);
            fetchNextUserList(node);
        });

        new NextNodeFetcher(lcid).start().subscribe(nextNodeResponse -> {
            msNodename.setItems(items(nextNodeResponse));
            NextNodeResponse.NextncodesBean node = nodes.get(0);
            fetchSpOption(node);
            fetchNextUserList(node);
        });

        RxView.clicks(dialog.getCustomView().findViewById(R.id.tvSubmit))
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> submit());
    }

    List<SpinnerItem> spOptionList;

    private void fetchSpOption(NextNodeResponse.NextncodesBean node) {
        if (showSpOption) {
            llSp.setVisibility(View.VISIBLE);
            List<SpinnerItem> temp = new ArrayList<>();
            String nodeName = node.getNodename();
            if (nodeName.contains("至拟稿人") || nodeName.equals("结束")) {
                temp.add(new SpinnerItem("commitToEnd", "同意并结束"));
            }
            temp.add(new SpinnerItem("commitToContinue", "同意并继续"));
            temp.add(new SpinnerItem("backToUpdate", "退回并整理"));
            temp.add(new SpinnerItem("backToEnd", "退回并结束"));
            msSp.setItems(items(temp));
            spOptionList = temp;
        }
    }

    private void fetchNextUserList(NextNodeResponse.NextncodesBean node) {
        new NextUserListFetcher(lcid, node.getNodeid(), sqr)
                .start()
                .subscribe(new Subscriber<NextUserListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NextUserListResponse nextUserListResponse) {
                        msUsername.setItems(items(nextUserListResponse));
                    }
                });
    }


    private void submit() {
        Map<String, Object> map = simpleSubmitter.getMap();
        NextUserListResponse.UserlistBean user = users.get(msUsername.getSelectedIndex());
        map.put("sprid", user.getUserid());
        map.put("sprmc", user.getUsername());
        NextNodeResponse.NextncodesBean node = nodes.get(msNodename.getSelectedIndex());
        map.put("spjdid", node.getNodeid());
        map.put("spjdmc", node.getNodename());

        if (showSpOption) {
            SpinnerItem sp = spOptionList.get(msSp.getSelectedIndex());
            map.put("nextParamsVal", sp.getValue());
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

    private List<String> items(List<SpinnerItem> spinnerItems) {
        List<String> items = new ArrayList<>();
        for (SpinnerItem spinnerItem : spinnerItems) {
            items.add(spinnerItem.getLabel());
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

    private List<NextUserListResponse.UserlistBean> users;

    private List<String> items(NextUserListResponse nextUserListResponse) {
        users = nextUserListResponse.getUserlist();
        List<String> items = new ArrayList<>();
        for (NextUserListResponse.UserlistBean user : nextUserListResponse.getUserlist()) {
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
