package com.zlt.gllys.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangletian on 16/7/20.
 */


public class UserInfo implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String userpwd;
    private String auth;
    private Date logintime;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public String getAuth() {
        return auth;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    @Override
    public String toString() {
        return username + "," + auth;
    }


}
