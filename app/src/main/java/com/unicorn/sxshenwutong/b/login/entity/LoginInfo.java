package com.unicorn.sxshenwutong.b.login.entity;

import com.unicorn.sxshenwutong.b.court.entity.Court;
import com.unicorn.sxshenwutong.b.court.entity.CourtDao;
import com.unicorn.sxshenwutong.b.court.entity.DaoSession;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

@Entity
public class LoginInfo {

    @Id
    private String loginName;

    @NotNull
    private String pwd;
    
    @NotNull
    private String courtDm;

    @ToOne(joinProperty = "courtDm")
    private Court court;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1787517186)
    private transient LoginInfoDao myDao;

    @Generated(hash = 2147121495)
    public LoginInfo(String loginName, @NotNull String pwd,
            @NotNull String courtDm) {
        this.loginName = loginName;
        this.pwd = pwd;
        this.courtDm = courtDm;
    }

    @Generated(hash = 1911824992)
    public LoginInfo() {
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCourtDm() {
        return this.courtDm;
    }

    public void setCourtDm(String courtDm) {
        this.courtDm = courtDm;
    }

    @Generated(hash = 1727557673)
    private transient String court__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 2084222915)
    public Court getCourt() {
        String __key = this.courtDm;
        if (court__resolvedKey == null || court__resolvedKey != __key) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CourtDao targetDao = daoSession.getCourtDao();
            Court courtNew = targetDao.load(__key);
            synchronized (this) {
                court = courtNew;
                court__resolvedKey = __key;
            }
        }
        return court;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1852680436)
    public void setCourt(@NotNull Court court) {
        if (court == null) {
            throw new DaoException(
                    "To-one property 'courtDm' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.court = court;
            courtDm = court.getDm();
            court__resolvedKey = courtDm;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 69224774)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLoginInfoDao() : null;
    }

}
