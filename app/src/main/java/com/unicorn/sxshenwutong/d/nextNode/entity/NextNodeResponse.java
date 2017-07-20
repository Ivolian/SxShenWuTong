package com.unicorn.sxshenwutong.d.nextNode.entity;

import java.util.List;

public class NextNodeResponse {

    private List<NextncodesBean> nextncodes;

    public List<NextncodesBean> getNextncodes() {
        return nextncodes;
    }

    public void setNextncodes(List<NextncodesBean> nextncodes) {
        this.nextncodes = nextncodes;
    }

    public static class NextncodesBean {
        /**
         * nodename : 庭长审批
         * nodeid : SPGL_AJJZP_TZSP
         */

        private String nodename;
        private String nodeid;

        public String getNodename() {
            return nodename;
        }

        public void setNodename(String nodename) {
            this.nodename = nodename;
        }

        public String getNodeid() {
            return nodeid;
        }

        public void setNodeid(String nodeid) {
            this.nodeid = nodeid;
        }
    }

}
