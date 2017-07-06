package com.unicorn.sxshenwutong.list;

import java.util.List;

public class ListResponse<T> {

    private Integer total;
    private List<T> models;

    //

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getModels() {
        return models;
    }

    public void setModels(List<T> models) {
        this.models = models;
    }

}
