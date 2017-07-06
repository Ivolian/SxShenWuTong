package com.unicorn.sxshenwutong.c.home;

import java.util.List;

public class HomeResponse {

    /**
     * maindata : {"zxsawl":25,"zxdbajs":9,"zxlawys":23,"spdsp":0,"zxdsp":0,"jjcsx":0,"spjawgd":6,"csxwj":4,"splawys":72,"spdbajs":23,"ktajs":0,"spjasc":0,"spsawl":279,"zxjasc":3,"zxjawgd":2}
     * mainpic : [{"jlid":1,"filename":"index_news2.jpg","filepath":"/upload/index_news2.jpg"},{"jlid":2,"filename":"index_news3.jpg","filepath":"/upload/index_news3.jpg"}]
     */

    private MaindataBean maindata;
    private List<MainpicBean> mainpic;

    public MaindataBean getMaindata() {
        return maindata;
    }

    public void setMaindata(MaindataBean maindata) {
        this.maindata = maindata;
    }

    public List<MainpicBean> getMainpic() {
        return mainpic;
    }

    public void setMainpic(List<MainpicBean> mainpic) {
        this.mainpic = mainpic;
    }

    public static class MaindataBean {
        /**
         * zxsawl : 25
         * zxdbajs : 9
         * zxlawys : 23
         * spdsp : 0
         * zxdsp : 0
         * jjcsx : 0
         * spjawgd : 6
         * csxwj : 4
         * splawys : 72
         * spdbajs : 23
         * ktajs : 0
         * spjasc : 0
         * spsawl : 279
         * zxjasc : 3
         * zxjawgd : 2
         */

        private int zxsawl;
        private int zxdbajs;
        private int zxlawys;
        private int spdsp;
        private int zxdsp;
        private int jjcsx;
        private int spjawgd;
        private int csxwj;
        private int splawys;
        private int spdbajs;
        private int ktajs;
        private int spjasc;
        private int spsawl;
        private int zxjasc;
        private int zxjawgd;

        public int getZxsawl() {
            return zxsawl;
        }

        public void setZxsawl(int zxsawl) {
            this.zxsawl = zxsawl;
        }

        public int getZxdbajs() {
            return zxdbajs;
        }

        public void setZxdbajs(int zxdbajs) {
            this.zxdbajs = zxdbajs;
        }

        public int getZxlawys() {
            return zxlawys;
        }

        public void setZxlawys(int zxlawys) {
            this.zxlawys = zxlawys;
        }

        public int getSpdsp() {
            return spdsp;
        }

        public void setSpdsp(int spdsp) {
            this.spdsp = spdsp;
        }

        public int getZxdsp() {
            return zxdsp;
        }

        public void setZxdsp(int zxdsp) {
            this.zxdsp = zxdsp;
        }

        public int getJjcsx() {
            return jjcsx;
        }

        public void setJjcsx(int jjcsx) {
            this.jjcsx = jjcsx;
        }

        public int getSpjawgd() {
            return spjawgd;
        }

        public void setSpjawgd(int spjawgd) {
            this.spjawgd = spjawgd;
        }

        public int getCsxwj() {
            return csxwj;
        }

        public void setCsxwj(int csxwj) {
            this.csxwj = csxwj;
        }

        public int getSplawys() {
            return splawys;
        }

        public void setSplawys(int splawys) {
            this.splawys = splawys;
        }

        public int getSpdbajs() {
            return spdbajs;
        }

        public void setSpdbajs(int spdbajs) {
            this.spdbajs = spdbajs;
        }

        public int getKtajs() {
            return ktajs;
        }

        public void setKtajs(int ktajs) {
            this.ktajs = ktajs;
        }

        public int getSpjasc() {
            return spjasc;
        }

        public void setSpjasc(int spjasc) {
            this.spjasc = spjasc;
        }

        public int getSpsawl() {
            return spsawl;
        }

        public void setSpsawl(int spsawl) {
            this.spsawl = spsawl;
        }

        public int getZxjasc() {
            return zxjasc;
        }

        public void setZxjasc(int zxjasc) {
            this.zxjasc = zxjasc;
        }

        public int getZxjawgd() {
            return zxjawgd;
        }

        public void setZxjawgd(int zxjawgd) {
            this.zxjawgd = zxjawgd;
        }
    }

    public static class MainpicBean {
        /**
         * jlid : 1
         * filename : index_news2.jpg
         * filepath : /upload/index_news2.jpg
         */

        private int jlid;
        private String filename;
        private String filepath;

        public int getJlid() {
            return jlid;
        }

        public void setJlid(int jlid) {
            this.jlid = jlid;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFilepath() {
            return filepath;
        }

        public void setFilepath(String filepath) {
            this.filepath = filepath;
        }
    }
}
