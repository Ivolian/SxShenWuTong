package com.unicorn.sxshenwutong.news.newsType.entity;

import java.io.Serializable;

public class NewsType implements Serializable{

    /**
     * sortno : 99.00
     * name : 破产公告
     * id : 1
     * type : 2
     */

    private String sortno;
    private String name;
    private String id;
    private String type;

    public String getSortno() {
        return sortno;
    }

    public void setSortno(String sortno) {
        this.sortno = sortno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
