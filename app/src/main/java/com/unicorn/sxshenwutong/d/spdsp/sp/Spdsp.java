package com.unicorn.sxshenwutong.d.spdsp.sp;

import java.util.List;

public class Spdsp {


    /**
     * yckcsxxx : {"ywid":"","qtsm":"","bgyy":"","lx":"1010490001","fdsx":"","lxmc":"延长","dw":"","qsrq":"2017-07-14","ajbs":"M00f79c4576-a2ee-46fb-b619-8bf6cf614f3d","pzrsf":"","sys_time":"2017-07-14 09:41:38.0","shbz":"0","pzjgmc":"","id":"M006559b964-6a1b-4f3e-88a6-b2b791f43b7f","kcts":"","kcsxws":"","sqrq":"","sprq":"2017-07-14","djrq":"","jssxbz":"","fydm":"M00","djr":"","xh":"2","ycts":"7","pzjg":"","spr":"","jsrq":"2017-07-21","pzrq":"","bglxmc":"请示待决","bglx":"1010491002"}
     * ajxx : {"laaymc":"姓名权纠纷","ahqc":"(2017)渝民初203号","sycxmc":"普通程序","dybg":"测试1","larq":"2017-07-14","dyyg":"测试"}
     * dblbxx : {"lcid":"CQ_DSP_SPGL_SP_FDSYSP","ywid":"M006559b964-6a1b-4f3e-88a6-b2b791f43b7f","processInstanceId":"aaf7c849-6835-11e7-ba7f-000c290c623b","sfcg":"","cqrq":"","cqzt":"1","fsnodename":"拟稿人发起申请","fsrmc":"张青","sort":"3","jlid":"M004fb95b8a-64e7-45a1-b535-81ad168969f2","fydm":"M00","sfdj":"","url":"/fdayspAction/updateToPage.action?processInstancesId=aaf7c849-6835-11e7-ba7f-000c290c623b&taskId=af15b408-6835-11e7-ba7f-000c290c623b&id=M006559b964-6a1b-4f3e-88a6-b2b791f43b7f&lcid=CQ_DSP_SPGL_SP_FDSYSP&nodeid=SPGL_FDSY_TZSP&jsrid=9933&xsUrl=","fsnodeid":"SPGL_FDSY_NGRFQSQ","jsrid":"9933","nodename":"庭长审批","bt":"(2017)渝民初203号法定事由审批","fsrid":"5277","jsrmc":"田晓梅","fssj":"2017-07-14 09:42:23.0","bmbm":"099","nodeid":"SPGL_FDSY_TZSP","taskid":"af15b408-6835-11e7-ba7f-000c290c623b","lcmc":"法定事由审批"}
     * spxx : {"lcid":"CQ_DSP_SPGL_SP_FDSYSP","processInstanceId":"aaf7c849-6835-11e7-ba7f-000c290c623b","sprmc":"张青","sqrmc":"张青","sqrq":"2017-07-14","sprq":"2017-07-14","spjdid":"SPGL_FDSY_TZSP","fydm":"M00","bt":"(2017)渝民初203号法定事由审批","spjdmc":"庭长审批","fz":"1","spr":"5277","sqr":"5277","ajbs":"M00f79c4576-a2ee-46fb-b619-8bf6cf614f3d","zt":"1","id":"M006559b964-6a1b-4f3e-88a6-b2b791f43b7f","TYPE":"","lcmc":"法定事由审批"}
     * spyjlist : [{"sprmc":"张青","ip":"149.0.40.15","sprq":"2017-07-14","sort":"1","jlid":"M008e1caade-7b3f-48b2-aed6-704207368b49","fydm":"M00","spid":"M006559b964-6a1b-4f3e-88a6-b2b791f43b7f","spl":"","nodename":"拟稿人","spr":"5277","sys_time":"2017-07-14 09:41:38.0","zt":"1","spyj":"<p><br/><\/p><p>张青 2017年7月14日<\/p>","nodeid":"SPGL_FDSY_NGRFQSQ"}]
     */

    private CxbgxxBean cxbgxx;
    private YckcsxxxBean yckcsxxx;
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

    public YckcsxxxBean getYckcsxxx() {
        return yckcsxxx;
    }

    public void setYckcsxxx(YckcsxxxBean yckcsxxx) {
        this.yckcsxxx = yckcsxxx;
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

    public static class YckcsxxxBean {
        /**
         * ywid :
         * qtsm :
         * bgyy :
         * lx : 1010490001
         * fdsx :
         * lxmc : 延长
         * dw :
         * qsrq : 2017-07-14
         * ajbs : M00f79c4576-a2ee-46fb-b619-8bf6cf614f3d
         * pzrsf :
         * sys_time : 2017-07-14 09:41:38.0
         * shbz : 0
         * pzjgmc :
         * id : M006559b964-6a1b-4f3e-88a6-b2b791f43b7f
         * kcts :
         * kcsxws :
         * sqrq :
         * sprq : 2017-07-14
         * djrq :
         * jssxbz :
         * fydm : M00
         * djr :
         * xh : 2
         * ycts : 7
         * pzjg :
         * spr :
         * jsrq : 2017-07-21
         * pzrq :
         * bglxmc : 请示待决
         * bglx : 1010491002
         */

        private String ywid;
        private String qtsm;
        private String bgyy;
        private String lx;
        private String fdsx;
        private String lxmc;
        private String dw;
        private String qsrq;
        private String ajbs;
        private String pzrsf;
        private String sys_time;
        private String shbz;
        private String pzjgmc;
        private String id;
        private String kcts;
        private String kcsxws;
        private String sqrq;
        private String sprq;
        private String djrq;
        private String jssxbz;
        private String fydm;
        private String djr;
        private String xh;
        private String ycts;
        private String pzjg;
        private String spr;
        private String jsrq;
        private String pzrq;
        private String bglxmc;
        private String bglx;

        public String getYwid() {
            return ywid;
        }

        public void setYwid(String ywid) {
            this.ywid = ywid;
        }

        public String getQtsm() {
            return qtsm;
        }

        public void setQtsm(String qtsm) {
            this.qtsm = qtsm;
        }

        public String getBgyy() {
            return bgyy;
        }

        public void setBgyy(String bgyy) {
            this.bgyy = bgyy;
        }

        public String getLx() {
            return lx;
        }

        public void setLx(String lx) {
            this.lx = lx;
        }

        public String getFdsx() {
            return fdsx;
        }

        public void setFdsx(String fdsx) {
            this.fdsx = fdsx;
        }

        public String getLxmc() {
            return lxmc;
        }

        public void setLxmc(String lxmc) {
            this.lxmc = lxmc;
        }

        public String getDw() {
            return dw;
        }

        public void setDw(String dw) {
            this.dw = dw;
        }

        public String getQsrq() {
            return qsrq;
        }

        public void setQsrq(String qsrq) {
            this.qsrq = qsrq;
        }

        public String getAjbs() {
            return ajbs;
        }

        public void setAjbs(String ajbs) {
            this.ajbs = ajbs;
        }

        public String getPzrsf() {
            return pzrsf;
        }

        public void setPzrsf(String pzrsf) {
            this.pzrsf = pzrsf;
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

        public String getPzjgmc() {
            return pzjgmc;
        }

        public void setPzjgmc(String pzjgmc) {
            this.pzjgmc = pzjgmc;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getKcts() {
            return kcts;
        }

        public void setKcts(String kcts) {
            this.kcts = kcts;
        }

        public String getKcsxws() {
            return kcsxws;
        }

        public void setKcsxws(String kcsxws) {
            this.kcsxws = kcsxws;
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

        public String getDjrq() {
            return djrq;
        }

        public void setDjrq(String djrq) {
            this.djrq = djrq;
        }

        public String getJssxbz() {
            return jssxbz;
        }

        public void setJssxbz(String jssxbz) {
            this.jssxbz = jssxbz;
        }

        public String getFydm() {
            return fydm;
        }

        public void setFydm(String fydm) {
            this.fydm = fydm;
        }

        public String getDjr() {
            return djr;
        }

        public void setDjr(String djr) {
            this.djr = djr;
        }

        public String getXh() {
            return xh;
        }

        public void setXh(String xh) {
            this.xh = xh;
        }

        public String getYcts() {
            return ycts;
        }

        public void setYcts(String ycts) {
            this.ycts = ycts;
        }

        public String getPzjg() {
            return pzjg;
        }

        public void setPzjg(String pzjg) {
            this.pzjg = pzjg;
        }

        public String getSpr() {
            return spr;
        }

        public void setSpr(String spr) {
            this.spr = spr;
        }

        public String getJsrq() {
            return jsrq;
        }

        public void setJsrq(String jsrq) {
            this.jsrq = jsrq;
        }

        public String getPzrq() {
            return pzrq;
        }

        public void setPzrq(String pzrq) {
            this.pzrq = pzrq;
        }

        public String getBglxmc() {
            return bglxmc;
        }

        public void setBglxmc(String bglxmc) {
            this.bglxmc = bglxmc;
        }

        public String getBglx() {
            return bglx;
        }

        public void setBglx(String bglx) {
            this.bglx = bglx;
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
         * lcid : CQ_DSP_SPGL_SP_FDSYSP
         * ywid : M006559b964-6a1b-4f3e-88a6-b2b791f43b7f
         * processInstanceId : aaf7c849-6835-11e7-ba7f-000c290c623b
         * sfcg :
         * cqrq :
         * cqzt : 1
         * fsnodename : 拟稿人发起申请
         * fsrmc : 张青
         * sort : 3
         * jlid : M004fb95b8a-64e7-45a1-b535-81ad168969f2
         * fydm : M00
         * sfdj :
         * url : /fdayspAction/updateToPage.action?processInstancesId=aaf7c849-6835-11e7-ba7f-000c290c623b&taskId=af15b408-6835-11e7-ba7f-000c290c623b&id=M006559b964-6a1b-4f3e-88a6-b2b791f43b7f&lcid=CQ_DSP_SPGL_SP_FDSYSP&nodeid=SPGL_FDSY_TZSP&jsrid=9933&xsUrl=
         * fsnodeid : SPGL_FDSY_NGRFQSQ
         * jsrid : 9933
         * nodename : 庭长审批
         * bt : (2017)渝民初203号法定事由审批
         * fsrid : 5277
         * jsrmc : 田晓梅
         * fssj : 2017-07-14 09:42:23.0
         * bmbm : 099
         * nodeid : SPGL_FDSY_TZSP
         * taskid : af15b408-6835-11e7-ba7f-000c290c623b
         * lcmc : 法定事由审批
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
         * lcid : CQ_DSP_SPGL_SP_FDSYSP
         * processInstanceId : aaf7c849-6835-11e7-ba7f-000c290c623b
         * sprmc : 张青
         * sqrmc : 张青
         * sqrq : 2017-07-14
         * sprq : 2017-07-14
         * spjdid : SPGL_FDSY_TZSP
         * fydm : M00
         * bt : (2017)渝民初203号法定事由审批
         * spjdmc : 庭长审批
         * fz : 1
         * spr : 5277
         * sqr : 5277
         * ajbs : M00f79c4576-a2ee-46fb-b619-8bf6cf614f3d
         * zt : 1
         * id : M006559b964-6a1b-4f3e-88a6-b2b791f43b7f
         * TYPE :
         * lcmc : 法定事由审批
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
         * jlid : M008e1caade-7b3f-48b2-aed6-704207368b49
         * fydm : M00
         * spid : M006559b964-6a1b-4f3e-88a6-b2b791f43b7f
         * spl :
         * nodename : 拟稿人
         * spr : 5277
         * sys_time : 2017-07-14 09:41:38.0
         * zt : 1
         * spyj : <p><br/></p><p>张青 2017年7月14日</p>
         * nodeid : SPGL_FDSY_NGRFQSQ
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
