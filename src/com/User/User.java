package com.User;

/**
 * Created by wxk on 2017/3/29.
 */
public class User {
    private int userid;
    private String usertype;
    private String username;
    private String password;
    //private String realname;
    //private String sex;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int id) {
        this.userid = id;
    }

    public String getUsertype() {
        return this.usertype;
    }

    public void setUsertype(String type) {
        this.usertype = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pswd) {
        this.password = pswd;
    }
}
