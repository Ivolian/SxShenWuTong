package com.unicorn.sxshenwutong.a.db;

import android.app.Application;

import com.unicorn.sxshenwutong.b.court.entity.DaoMaster;
import com.unicorn.sxshenwutong.b.court.entity.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;

@com.unicorn.sxshenwutong.a.dagger.App
public class DaoSessionProvider {

    private final Application application;

    @Inject
    public DaoSessionProvider(Application application) {
        this.application = application;

    }

    public DaoSession provide() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(application.getApplicationContext(), "sx-db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }

}