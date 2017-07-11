package com.unicorn.sxshenwutong.list;

import android.os.Bundle;
import android.widget.TextView;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.GeneralService;
import com.unicorn.sxshenwutong.a.app.ParamsInitializer;
import com.unicorn.sxshenwutong.a.app.entity.Params;
import com.unicorn.sxshenwutong.a.base.RefreshAct;
import com.unicorn.sxshenwutong.a.constant.Key;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import pocketknife.BindExtra;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.unicorn.sxshenwutong.a.constant.Key.SUCCESS_CODE;
import static com.unicorn.sxshenwutong.a.constant.Key.YDBAKEY;


abstract public class ListAct<T> extends RefreshAct<T> {

    @Override
    protected int layoutResId() {
        return R.layout.act_list;
    }


//    @Override
//    protected BaseQuickAdapter<T, BaseViewHolder> getAdapter() {
//        return new ListAdapter();
//    }

    @BindView(R.id.tvTitle)
    TextView tvTitle;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        clickBack();
        tvTitle.setText(title);
    }

    @BindExtra(Key.TITLE)
    String title;

    @BindExtra(Key.LBTYPE)
    String lbtype;

    @Override
    protected Observable<ListResponse<T>> load() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("page", pageNo);
        parameters.put("pageSize", PAGE_SIZE);
        parameters.put(Key.LBTYPE, lbtype);
        paramsInitializer.initParams(params, "getLbList", parameters);


        return generalService.get(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(response -> response.getCode().equals(SUCCESS_CODE))
                .map(response -> response.getParameters().get(YDBAKEY))
                .map(this::gson);
    }

    @Inject
    ParamsInitializer paramsInitializer;

    @Inject
    GeneralService generalService;

    abstract protected ListResponse<T> gson(String ydbaKey);

}
