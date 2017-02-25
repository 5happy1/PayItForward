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
    User author;
    ArrayList<User> taggedUsers;
    ArrayList<User> likes;

    // TODO: Read in data from backend

    public Deed(String title, String description, User author, ArrayList<User> taggedUsers) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.taggedUsers = taggedUsers;
        likes = new ArrayList<>();
    }
}
