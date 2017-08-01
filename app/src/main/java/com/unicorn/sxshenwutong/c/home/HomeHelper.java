package com.unicorn.sxshenwutong.c.home;

import com.unicorn.sxshenwutong.R;
import com.unicorn.sxshenwutong.a.app.Global;
import com.unicorn.sxshenwutong.c.home.entity.HomeItem;
import com.unicorn.sxshenwutong.c.home.entity.HomeResponse;

import java.util.Arrays;

/*
审判法官显示：
spjawgd:审判结案未归档，spsawl：审判收案未立，splawys：审判立案未移送
spdbajs：审判待办案件，spdsp：审判待审批数，spjasc：审判结案审查数，
jjcsx：即将超审限，csxwj：超审限未结，ktajs：开庭案件数

执行法官显示：
zxjawgd：执行结案未归档， zxsawl：执行收案未立，zxlawys：执行立案未移送
zxdbajs：执行待办案件，zxdsp：执行待审批数， zxjasc：执行结案审查数，
jjcsx：即将超审限，csxwj：超审限未结，ktajs：开庭案件数


 */

class HomeHelper {

    void refreshHomeItem(HomeResponse homeResponse) {
        HomeResponse.MaindataBean mainData = homeResponse.getMaindata();
        String userTypeDm = Global.getLoginResponse().getUser().getUsertype();
        switch (userTypeDm) {
            case "9000010001":
                Global.setHomeItemListTop(Arrays.asList(
                        new HomeItem("审判结案未归档", mainData.getSpjawgd(), "spjawgdlist"),
                        new HomeItem("审判收案未立", mainData.getSpsawl(), "spsawllist"),
                        new HomeItem("审判立案未移送", mainData.getSplawys(), "splawyslist")
                ));
                Global.setHomeItemListBottom(Arrays.asList(
                        new HomeItem("审判待办", R.drawable.spdb, mainData.getSpdbajs(), "spdblist"),
                        new HomeItem("审判待审批", R.drawable.spdsp, mainData.getSpdsp(), "spdsplist"),
                        new HomeItem("审判结案审查", R.drawable.spjasc, mainData.getSpjasc(), "spjasclist"),
                        new HomeItem("即将超审限", R.drawable.jjcsx, mainData.getJjcsx(), "jjcsxlist"),
                        new HomeItem("已超审限", R.drawable.ycsx, mainData.getCsxwj(), "ycsxlist"),
                        new HomeItem("当天开庭", R.drawable.more, mainData.getKtajs(), "dtktlist")
                ));
                break;
            case "9000010002":
                Global.setHomeItemListTop(Arrays.asList(
                        new HomeItem("执行结案未归档", mainData.getZxjawgd(), "zxjawgdlist"),
                        new HomeItem("执行收案未立", mainData.getZxsawl(), "zxsawllist"),
                        new HomeItem("执行立案未移送", mainData.getZxlawys(), "zxlawyslist")
                ));
                Global.setHomeItemListBottom(Arrays.asList(
                        new HomeItem("执行待办", R.drawable.zxdb, mainData.getZxdbajs(), "zxdblist"),
                        new HomeItem("执行待审批", R.drawable.zxdsp, mainData.getZxdsp(), "zxdsplist"),
                        new HomeItem("执行结案审查", R.drawable.zxjasc, mainData.getZxjasc(), "zxjasclist"),
                        new HomeItem("即将超审限", R.drawable.jjcsx, mainData.getJjcsx(), "jjcsxlist"),
                        new HomeItem("已超审限", R.drawable.ycsx, mainData.getCsxwj(), "ycsxlist"),
                        new HomeItem("当天开庭", R.drawable.more, mainData.getKtajs(), "dtktlist")
                ));
                break;
            default:
                Global.setHomeItemListTop(Arrays.asList(
                        new HomeItem("审判结案未归档", mainData.getSpjawgd(), "spjawgdlist"),
                        new HomeItem("审判收案未立", mainData.getSpsawl(), "spsawllist"),
                        new HomeItem("审判立案未移送", mainData.getSplawys(), "splawyslist"),
                        new HomeItem("执行结案未归档", mainData.getZxjawgd(), "zxjawgdlist"),
                        new HomeItem("执行收案未立", mainData.getZxsawl(), "zxsawllist"),
                        new HomeItem("执行立案未移送", mainData.getZxlawys(), "zxlawyslist")
                ));
                Global.setHomeItemListBottom(Arrays.asList(
                        new HomeItem("审判待办", R.drawable.spdb, mainData.getSpdbajs(), "spdblist"),
                        new HomeItem("审判待审批", R.drawable.spdsp, mainData.getSpdsp(), "spdsplist"),
                        new HomeItem("审判结案审查", R.drawable.spjasc, mainData.getSpjasc(), "spjasclist"),
                        new HomeItem("执行待办", R.drawable.zxdb, mainData.getZxdbajs(), "zxdblist"),
                        new HomeItem("执行待审批", R.drawable.zxdsp, mainData.getZxdsp(), "zxdsplist"),
                        new HomeItem("执行结案审查", R.drawable.zxjasc, mainData.getZxjasc(), "zxjasclist"),
                        new HomeItem("即将超审限", R.drawable.jjcsx, mainData.getJjcsx(), "jjcsxlist"),
                        new HomeItem("已超审限", R.drawable.ycsx, mainData.getCsxwj(), "ycsxlist"),
                        new HomeItem("当天开庭", R.drawable.more, mainData.getKtajs(), "dtktlist")
                ));
        }
    }

}
