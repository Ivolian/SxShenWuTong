package com.unicorn.sxshenwutong.d.spdsp;

import java.util.List;

public class SpdspFull {


    /**
     * cxbgxx : {"cxbglxmc":"简易程序（非小额诉讼）","jlid":"M000d113a08-3fd7-4955-a9f1-c1a4643af909","fydm":"M00","xh":"0","jyzptsprbs":"","sqsycxlxmc":"普通程序","jyzptyymc":"诉讼请求或当事人变化致使案件不再符合一审终审条件","jyzptrq":"","jyzptyy":"1320020001","ajbs":"M00f79c4576-a2ee-46fb-b619-8bf6cf614f3d","jyzptspr":"","sys_time":"2017-07-14 09:42:11.0","shbz":"0","sqsycxlx":"20001","cxbglx":"10202"}
     * ajxx : {"laaymc":"姓名权纠纷","ahqc":"(2017)渝民初203号","sycxmc":"普通程序","dybg":"测试1","larq":"2017-07-14","dyyg":"测试"}
     * dblbxx : {"lcid":"CQ_DSP_SPGL_SP_AJJZPSP","ywid":"M000d113a08-3fd7-4955-a9f1-c1a4643af909","processInstanceId":"bece357f-6835-11e7-ba7f-000c290c623b","sfcg":"","cqrq":"","cqzt":"1","fsnodename":"拟稿人发起申请","fsrmc":"张青","sort":"3","jlid":"M00261dc8b0-91ca-49f7-8c50-81b331c1f138","fydm":"M00","sfdj":"","url":"/cxbgAction/updateToPage.action?processInstancesId=bece357f-6835-11e7-ba7f-000c290c623b&taskId=c1f6779e-6835-11e7-ba7f-000c290c623b&id=M000d113a08-3fd7-4955-a9f1-c1a4643af909&lcid=CQ_DSP_SPGL_SP_AJJZPSP&nodeid=SPGL_AJJZP_TZSP&jsrid=9933&xsUrl=","fsnodeid":"SPGL_AJJZP_NGRFQSQ","jsrid":"9933","nodename":"庭长审批","bt":"(2017)渝民初203号适用程序变更审批","fsrid":"5277","jsrmc":"田晓梅","fssj":"2017-07-14 09:42:55.0","bmbm":"099","nodeid":"SPGL_AJJZP_TZSP","taskid":"c1f6779e-6835-11e7-ba7f-000c290c623b","lcmc":"案件简转普审批"}
     * spxx : {"lcid":"CQ_DSP_SPGL_SP_AJJZPSP","processInstanceId":"bece357f-6835-11e7-ba7f-000c290c623b","sprmc":"张青","sqrmc":"张青","sqrq":"2017-07-14","sprq":"2017-07-14","spjdid":"SPGL_AJJZP_TZSP","fydm":"M00","bt":"(2017)渝民初203号适用程序变更审批","spjdmc":"庭长审批","fz":"1","spr":"5277","sqr":"5277","ajbs":"M00f79c4576-a2ee-46fb-b619-8bf6cf614f3d","zt":"1","id":"M000d113a08-3fd7-4955-a9f1-c1a4643af909","TYPE":"","lcmc":"适用程序变更审批"}
     * spyjlist : [{"sprmc":"张青","ip":"149.0.40.15","sprq":"2017-07-14","sort":"1","jlid":"M00aeaeb0e3-2eba-4663-9536-2737fc0bcc9e","fydm":"M00","spid":"M000d113a08-3fd7-4955-a9f1-c1a4643af909","spl":"","nodename":"拟稿人","spr":"5277","sys_time":"2017-07-14 09:42:11.0","zt":"1","spyj":"<p><br/><\/p><p>张青 2017年7月14日<\/p>","nodeid":"SPGL_AJJZP_NGRFQSQ"}]
     */

    private CxbgxxBean cxbgxx;
    private AjxxBean ajxx;
    private DblbxxBean dblbxx;
    private SpxxBean spxx;
    private List<SpyjlistBean> spyjlist;

    public CxbgxxBean getCxbgxx() {
        return cxbgxx;
    }

    public void setCxbgxx(CxbgxxBean cxbgxx) {
        this.cxbgxx = cxbgxx;
    }

    public AjxxBean getAjxx() {
        return ajxx;
    }

    public void setAjxx(AjxxBean ajxx) {
        this.ajxx = ajxx;
    }

    public DblbxxBean getDblbxx() {
        return dblbxx;
    }

    public void setDblbxx(DblbxxBean dblbxx) {
        this.dblbxx = dblbxx;
    }

    public SpxxBean getSpxx() {
        return spxx;
    }

    public void setSpxx(SpxxBean spxx) {
        this.spxx = spxx;
    }

    public List<SpyjlistBean> getSpyjlist() {
        return spyjlist;
    }

    public void setSpyjlist(List<SpyjlistBean> spyjlist) {
        this.spyjlist = spyjlist;
    }

    public static class CxbgxxBean {
        /**
         * cxbglxmc : 简易程序（非小额诉讼）
         * jlid : M000d113a08-3fd7-4955-a9f1-c1a4643af909
         * fydm : M00
         * xh : 0
         * jyzptsprbs :
         * sqsycxlxmc : 普通程序
         * jyzptyymc : 诉讼请求或当事人变化致使案件不再符合一审终审条件
         * jyzptrq :
         * jyzptyy : 1320020001
         * ajbs : M00f79c4576-a2ee-46fb-b619-8bf6cf614f3d
         * jyzptspr :
         * sys_time : 2017-07-14 09:42:11.0
         * shbz : 0
         * sqsycxlx : 20001
         * cxbglx : 10202
         */

        private String cxbglxmc;
        private String jlid;
        private String fydm;
        private String xh;
        private String jyzptsprbs;
        private String sqsycxlxmc;
        private String jyzptyymc;
        private String jyzptrq;
        private String jyzptyy;
        private String ajbs;
        private String jyzptspr;
        private String sys_time;
        private String shbz;
        private String sqsycxlx;
        private String cxbglx;

        public String getCxbglxmc() {
            return cxbglxmc;
        }

        public void setCxbglxmc(String cxbglxmc) {
            this.cxbglxmc = cxbglxmc;
        }

        public String getJlid() {
            return jlid;
        }

        public void setJlid(String jlid) {
            this.jlid = jlid;
        }

        public String getFydm() {
            return fydm;
        }

        public void setFydm(String fydm) {
            this.fydm = fydm;
        }

        public String getXh() {
            return xh;
        }

        public void setXh(String xh) {
            this.xh = xh;
        }

        public String getJyzptsprbs() {
            return jyzptsprbs;
        }

        public void setJyzptsprbs(String jyzptsprbs) {
            this.jyzptsprbs = jyzptsprbs;
        }

        public String getSqsycxlxmc() {
            return sqsycxlxmc;
        }

        public void setSqsycxlxmc(String sqsycxlxmc) {
            this.sqsycxlxmc = sqsycxlxmc;
        }

        public String getJyzptyymc() {
            return jyzptyymc;
        }

        public void setJyzptyymc(String jyzptyymc) {
            this.jyzptyymc = jyzptyymc;
        }

        public String getJyzptrq() {
            return jyzptrq;
        }

        public void setJyzptrq(String jyzptrq) {
            this.jyzptrq = jyzptrq;
        }

        public String getJyzptyy() {
            return jyzptyy;
        }

        public void setJyzptyy(String jyzptyy) {
            this.jyzptyy = jyzptyy;
        }

        public String getAjbs() {
            return ajbs;
        }

        public void setAjbs(String ajbs) {
            this.ajbs = ajbs;
        }

        public String getJyzptspr() {
            return jyzptspr;
        }

        public void setJyzptspr(String jyzptspr) {
            this.jyzptspr = jyzptspr;
        }

        public String getSys_time() {
            return sys_time;
        }

        public void setSys_time(String sys_time) {
            this.sys_time = sys_time;
        }

        public String getShbz() {
            return shbz;
        }

        public void setShbz(String shbz) {
            this.shbz = shbz;
        }

        public String getSqsycxlx() {
            return sqsycxlx;
        }

        public void setSqsycxlx(String sqsycxlx) {
            this.sqsycxlx = sqsycxlx;
        }

        public String getCxbglx() {
            return cxbglx;
        }

        public void setCxbglx(String cxbglx) {
            this.cxbglx = cxbglx;
        }
    }

    public static class AjxxBean {
        /**
         * laaymc : 姓名权纠纷
         * ahqc : (2017)渝民初203号
         * sycxmc : 普通程序
         * dybg : 测试1
         * larq : 2017-07-14
         * dyyg : 测试
         */

        private String laaymc;
        private String ahqc;
        private String sycxmc;
        private String dybg;
        private String larq;
        private String dyyg;

        public String getLaaymc() {
            return laaymc;
        }

        public void setLaaymc(String laaymc) {
            this.laaymc = laaymc;
        }

        public String getAhqc() {
            return ahqc;
        }

        public void setAhqc(String ahqc) {
            this.ahqc = ahqc;
        }

        public String getSycxmc() {
            return sycxmc;
        }

        public void setSycxmc(String sycxmc) {
            this.sycxmc = sycxmc;
        }

        public String getDybg() {
            return dybg;
        }

        public void setDybg(String dybg) {
            this.dybg = dybg;
        }

        public String getLarq() {
            return larq;
        }

        public void setLarq(String larq) {
            this.larq = larq;
        }

        public String getDyyg() {
            return dyyg;
        }

        public void setDyyg(String dyyg) {
            this.dyyg = dyyg;
        }
    }

    public static class DblbxxBean {
        /**
         * lcid : CQ_DSP_SPGL_SP_AJJZPSP
         * ywid : M000d113a08-3fd7-4955-a9f1-c1a4643af909
         * processInstanceId : bece357f-6835-11e7-ba7f-000c290c623b
         * sfcg :
         * cqrq :
         * cqzt : 1
         * fsnodename : 拟稿人发起申请
         * fsrmc : 张青
         * sort : 3
         * jlid : M00261dc8b0-91ca-49f7-8c50-81b331c1f138
         * fydm : M00
         * sfdj :
         * url : /cxbgAction/updateToPage.action?processInstancesId=bece357f-6835-11e7-ba7f-000c290c623b&taskId=c1f6779e-6835-11e7-ba7f-000c290c623b&id=M000d113a08-3fd7-4955-a9f1-c1a4643af909&lcid=CQ_DSP_SPGL_SP_AJJZPSP&nodeid=SPGL_AJJZP_TZSP&jsrid=9933&xsUrl=
         * fsnodeid : SPGL_AJJZP_NGRFQSQ
         * jsrid : 9933
         * nodename : 庭长审批
         * bt : (2017)渝民初203号适用程序变更审批
         * fsrid : 5277
         * jsrmc : 田晓梅
         * fssj : 2017-07-14 09:42:55.0
         * bmbm : 099
         * nodeid : SPGL_AJJZP_TZSP
         * taskid : c1f6779e-6835-11e7-ba7f-000c290c623b
         * lcmc : 案件简转普审批
         */

        private String lcid;
        private String ywid;
        private String processInstanceId;
        private String sfcg;
        private String cqrq;
        private String cqzt;
        private String fsnodename;
        private String fsrmc;
        private String sort;
        private String jlid;
        private String fydm;
        private String sfdj;
        private String url;
        private String fsnodeid;
        private String jsrid;
        private String nodename;
        private String bt;
        private String fsrid;
        private String jsrmc;
        private String fssj;
        private String bmbm;
        private String nodeid;
        private String taskid;
        private String lcmc;

        public String getLcid() {
            return lcid;
        }

        public void setLcid(String lcid) {
            this.lcid = lcid;
        }

        public String getYwid() {
            return ywid;
        }

        public void setYwid(String ywid) {
            this.ywid = ywid;
        }

        public String getProcessInstanceId() {
            return processInstanceId;
        }

        public void setProcessInstanceId(String processInstanceId) {
            this.processInstanceId = processInstanceId;
        }

        public String getSfcg() {
            return sfcg;
        }

        public void setSfcg(String sfcg) {
            this.sfcg = sfcg;
        }

        public String getCqrq() {
            return cqrq;
        }

        public void setCqrq(String cqrq) {
            this.cqrq = cqrq;
        }

        public String getCqzt() {
            return cqzt;
        }

        public void setCqzt(String cqzt) {
            this.cqzt = cqzt;
        }

        public String getFsnodename() {
            return fsnodename;
        }

        public void setFsnodename(String fsnodename) {
            this.fsnodename = fsnodename;
        }

        public String getFsrmc() {
            return fsrmc;
        }

        public void setFsrmc(String fsrmc) {
            this.fsrmc = fsrmc;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getJlid() {
            return jlid;
        }

        public void setJlid(String jlid) {
            this.jlid = jlid;
        }

        public String getFydm() {
            return fydm;
        }

        public void setFydm(String fydm) {
            this.fydm = fydm;
        }

        public String getSfdj() {
            return sfdj;
        }

        public void setSfdj(String sfdj) {
            this.sfdj = sfdj;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFsnodeid() {
            return fsnodeid;
        }

        public void setFsnodeid(String fsnodeid) {
            this.fsnodeid = fsnodeid;
        }

        public String getJsrid() {
            return jsrid;
        }

        public void setJsrid(String jsrid) {
            this.jsrid = jsrid;
        }

        public String getNodename() {
            return nodename;
        }

        public void setNodename(String nodename) {
            this.nodename = nodename;
        }

        public String getBt() {
            return bt;
        }

        public void setBt(String bt) {
            this.bt = bt;
        }

        public String getFsrid() {
            return fsrid;
        }

        public void setFsrid(String fsrid) {
            this.fsrid = fsrid;
        }

        public String getJsrmc() {
            return jsrmc;
        }

        public void setJsrmc(String jsrmc) {
            this.jsrmc = jsrmc;
        }

        public String getFssj() {
            return fssj;
        }

        public void setFssj(String fssj) {
            this.fssj = fssj;
        }

        public String getBmbm() {
            return bmbm;
        }

        public void setBmbm(String bmbm) {
            this.bmbm = bmbm;
        }

        public String getNodeid() {
            return nodeid;
        }

        public void setNodeid(String nodeid) {
            this.nodeid = nodeid;
        }

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public String getLcmc() {
            return lcmc;
        }

        public void setLcmc(String lcmc) {
            this.lcmc = lcmc;
        }
    }

    public static class SpxxBean {
        /**
         * lcid : CQ_DSP_SPGL_SP_AJJZPSP
         * processInstanceId : bece357f-6835-11e7-ba7f-000c290c623b
         * sprmc : 张青
         * sqrmc : 张青
         * sqrq : 2017-07-14
         * sprq : 2017-07-14
         * spjdid : SPGL_AJJZP_TZSP
         * fydm : M00
         * bt : (2017)渝民初203号适用程序变更审批
         * spjdmc : 庭长审批
         * fz : 1
         * spr : 5277
         * sqr : 5277
         * ajbs : M00f79c4576-a2ee-46fb-b619-8bf6cf614f3d
         * zt : 1
         * id : M000d113a08-3fd7-4955-a9f1-c1a4643af909
         * TYPE :
         * lcmc : 适用程序变更审批
         */

        private String lcid;
        private String processInstanceId;
        private String sprmc;
        private String sqrmc;
        private String sqrq;
        private String sprq;
        private String spjdid;
        private String fydm;
        private String bt;
        private String spjdmc;
        private String fz;
        private String spr;
        private String sqr;
        private String ajbs;
        private String zt;
        private String id;
        private String TYPE;
        private String lcmc;

        public String getLcid() {
            return lcid;
        }

        public void setLcid(String lcid) {
            this.lcid = lcid;
        }

        public String getProcessInstanceId() {
            return processInstanceId;
        }

        public void setProcessInstanceId(String processInstanceId) {
            this.processInstanceId = processInstanceId;
        }

        public String getSprmc() {
            return sprmc;
        }

        public void setSprmc(String sprmc) {
            this.sprmc = sprmc;
        }

        public String getSqrmc() {
            return sqrmc;
        }

        public void setSqrmc(String sqrmc) {
            this.sqrmc = sqrmc;
        }

        public String getSqrq() {
            return sqrq;
        }

        public void setSqrq(String sqrq) {
            this.sqrq = sqrq;
        }

        public String getSprq() {
            return sprq;
        }

        public void setSprq(String sprq) {
            this.sprq = sprq;
        }

        public String getSpjdid() {
            return spjdid;
        }

        public void setSpjdid(String spjdid) {
            this.spjdid = spjdid;
        }

        public String getFydm() {
            return fydm;
        }

        public void setFydm(String fydm) {
            this.fydm = fydm;
        }

        public String getBt() {
            return bt;
        }

        public void setBt(String bt) {
            this.bt = bt;
        }

        public String getSpjdmc() {
            return spjdmc;
        }

        public void setSpjdmc(String spjdmc) {
            this.spjdmc = spjdmc;
        }

        public String getFz() {
            return fz;
        }

        public void setFz(String fz) {
            this.fz = fz;
        }

        public String getSpr() {
            return spr;
        }

        public void setSpr(String spr) {
            this.spr = spr;
        }

        public String getSqr() {
            return sqr;
        }

        public void setSqr(String sqr) {
            this.sqr = sqr;
        }

        public String getAjbs() {
            return ajbs;
        }

        public void setAjbs(String ajbs) {
            this.ajbs = ajbs;
        }

        public String getZt() {
            return zt;
        }

        public void setZt(String zt) {
            this.zt = zt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public String getLcmc() {
            return lcmc;
        }

        public void setLcmc(String lcmc) {
            this.lcmc = lcmc;
        }
    }

    public static class SpyjlistBean {
        /**
         * sprmc : 张青
         * ip : 149.0.40.15
         * sprq : 2017-07-14
         * sort : 1
         * jlid : M00aeaeb0e3-2eba-4663-9536-2737fc0bcc9e
         * fydm : M00
         * spid : M000d113a08-3fd7-4955-a9f1-c1a4643af909
         * spl :
         * nodename : 拟稿人
         * spr : 5277
         * sys_time : 2017-07-14 09:42:11.0
         * zt : 1
         * spyj : <p><br/></p><p>张青 2017年7月14日</p>
         * nodeid : SPGL_AJJZP_NGRFQSQ
         */

        private String sprmc;
        private String ip;
        private String sprq;
        private String sort;
        private String jlid;
        private String fydm;
        private String spid;
        private String spl;
        private String nodename;
        private String spr;
        private String sys_time;
        private String zt;
        private String spyj;
        private String nodeid;

        public String getSprmc() {
            return sprmc;
        }

        public void setSprmc(String sprmc) {
            this.sprmc = sprmc;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getSprq() {
            return sprq;
        }

        public void setSprq(String sprq) {
            this.sprq = sprq;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getJlid() {
            return jlid;
        }

        public void setJlid(String jlid) {
            this.jlid = jlid;
        }

        public String getFydm() {
            return fydm;
        }

        public void setFydm(String fydm) {
            this.fydm = fydm;
        }

        public String getSpid() {
            return spid;
        }

        public void setSpid(String spid) {
            this.spid = spid;
        }

        public String getSpl() {
            return spl;
        }

        public void setSpl(String spl) {
            this.spl = spl;
        }

        public String getNodename() {
            return nodename;
        }

        public void setNodename(String nodename) {
            this.nodename = nodename;
        }

        public String getSpr() {
            return spr;
        }

        public void setSpr(String spr) {
            this.spr = spr;
        }

        public String getSys_time() {
            return sys_time;
        }

        public void setSys_time(String sys_time) {
            this.sys_time = sys_time;
        }

        public String getZt() {
            return zt;
        }

        public void setZt(String zt) {
            this.zt = zt;
        }

        public String getSpyj() {
            return spyj;
        }

        public void setSpyj(String spyj) {
            this.spyj = spyj;
        }

        public String getNodeid() {
            return nodeid;
        }

        public void setNodeid(String nodeid) {
            this.nodeid = nodeid;
        }
    }
}
