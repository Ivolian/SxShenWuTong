package com.unicorn.sxshenwutong.userList;

import java.util.List;

public class UserListResponse {

    private List<UserlistBean> userlist;

    public List<UserlistBean> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserlistBean> userlist) {
        this.userlist = userlist;
    }

    public static class UserlistBean {
        /**
         * departname : 院领导
         * fymc : 重庆市高级人民法院
         * departid : 000
         * fydm : M00
         * userid : 42619
         * username : 杨临萍
         */

        private String departname;
        private String fymc;
        private String departid;
        private String fydm;
        private String userid;
        private String username;

        public String getDepartname() {
            return departname;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
        }

        public String getFymc() {
            return fymc;
        }

        public void setFymc(String fymc) {
            this.fymc = fymc;
        }

        public String getDepartid() {
            return departid;
        }

        public void setDepartid(String departid) {
            this.departid = departid;
        }

        public String getFydm() {
            return fydm;
        }

        public void setFydm(String fydm) {
            this.fydm = fydm;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

}
