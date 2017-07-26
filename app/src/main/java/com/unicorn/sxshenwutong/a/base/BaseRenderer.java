package com.unicorn.sxshenwutong.a.base;

import com.chad.library.adapter.base.BaseViewHolder;

abstract public class BaseRenderer<T> {

    protected BaseViewHolder viewHolder;
    protected T entity;

    public BaseRenderer(BaseViewHolder viewHolder, T entity) {
        this.viewHolder = viewHolder;
        this.entity = entity;
    }

    abstract public void render();

}
