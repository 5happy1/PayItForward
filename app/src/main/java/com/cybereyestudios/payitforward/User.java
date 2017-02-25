package com.cybereyestudios.payitforward;

import java.util.List;

/**
 * Structure for holding users.
 */

public class User {
    private String username;
    private String realName;

    public User(String username, String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }
}
