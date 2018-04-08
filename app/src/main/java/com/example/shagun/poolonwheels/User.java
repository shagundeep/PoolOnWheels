package com.example.shagun.poolonwheels;

import java.math.BigInteger;

/**
 * Created by shagu on 08-04-2018.
 */

public class User {
    String username;
    String userid;
    String userpassword;
    String userage;
    String usernumber;
    String usergender;

    public User() {

    }

    public User(String username, String userid, String userpassword, String userage, String usernumber, String usergender) {
        this.username = username;
        this.userid = userid;
        this.userpassword = userpassword;
        this.userage = userage;
        this.usernumber = usernumber;
        this.usergender = usergender;
    }

    public String getUsername() {
        return username;
    }

    public String getUserid() {
        return userid;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getUserage() {
        return userage;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public String getUsergender() {
        return usergender;
    }
}
