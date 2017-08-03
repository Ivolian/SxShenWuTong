package com.unicorn.sxshenwutong.db.ajws.select.entity;

import com.unicorn.sxshenwutong.db.ajws.ajws.entity.Ajws;

public class AjwsWrapper {

    private Ajws ajws;
    private boolean checked;

    public AjwsWrapper(Ajws ajws, boolean checked) {
        this.ajws = ajws;
        this.checked = checked;
    }

    public Ajws getAjws() {
        return ajws;
    }

    public void setAjws(Ajws ajws) {
        this.ajws = ajws;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
