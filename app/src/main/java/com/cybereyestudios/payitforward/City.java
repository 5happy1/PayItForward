package com.cybereyestudios.payitforward;

/**
 * Created by Samuel Rabinowitz on 2/25/2017.
 */

public class City {
    public int id;
    public String name;

    public City() {

    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
