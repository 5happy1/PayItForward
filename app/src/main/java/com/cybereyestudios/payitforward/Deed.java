package com.cybereyestudios.payitforward;

import java.util.ArrayList;
import java.util.Date;

/**
 * Structure for holding deeds.
 */
public class Deed {
    protected String title;
    protected String description;
    protected Date dateCreated;
    ArrayList<User> taggedUsers;
    ArrayList<User> likes;

    // TODO: Read in data from backend

    public Deed(String title, String description, ArrayList<User> taggedUsers) {
        this.title = title;
        this.description = description;
        this.taggedUsers = taggedUsers;
        likes = new ArrayList<>();
    }
}
