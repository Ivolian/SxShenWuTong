package com.unicorn.sxshenwutong.code;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;
import com.unicorn.sxshenwutong.general.Params;
import com.unicorn.sxshenwutong.general.ParamsHelper;
import com.unicorn.sxshenwutong.general.Response;
import com.unicorn.sxshenwutong.base.Global;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


@com.unicorn.sxshenwutong.dagger.App
public class CodeHelper {

    private ParamsHelper paramsHelper;
    private CodeService codeService;

    @Inject
    public CodeHelper(ParamsHelper paramsHelper, CodeService codeService) {
        this.paramsHelper = paramsHelper;
        this.codeService = codeService;
    }

    public void s() {
        Params params = new Params();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bxh", "900001");
        paramsHelper.initParams(params, "getBm", parameters);
        codeService
                .getCode(params.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("");
                    }

                    @Override
                    public void onNext(Response o) {
                     copeResponse(o);
                    }
                });
    }




    private void copeResponse(Response response) {
        if (response.getCode().equals("000000")) {
            LinkedTreeMap<String, String> parameters = (LinkedTreeMap<String, String>) response.getParameters();
            String ydbaKey = parameters.get("ydbaKey");
            try {
                JSONObject jsonObject = new JSONObject(ydbaKey);
                String str = jsonObject.getJSONArray("bmlist").toString();
                List<Code> codes = new Gson().fromJson(str,
                        new TypeToken<List<Code>>() {
                        }.getType());
                Global.codes = codes;
                Logger.d("");
//                for (Court court : courts) {
//                    court.setPinyin(Pinyin.toPinyin(court.getFyjc(), ""));
//                }
//                courtAdapter.setDatas(courts);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
