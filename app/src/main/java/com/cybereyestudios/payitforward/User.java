package com.cybereyestudios.payitforward;

import java.util.List;

/**
 * Structure for holding users.
 */

public class User {
    protected String username;
    protected String realName;

    protected User() {

    }

    public User(String username, String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }
}
