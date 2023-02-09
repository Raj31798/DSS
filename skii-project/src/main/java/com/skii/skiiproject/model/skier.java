package com.skii.skiiproject.model;

import javax.management.ConstructorParameters;

public class skier {

    private final int id;
    private final long time;

    public int getId() {
        return id;
    }

    public long getTime() {
        return time;
    }

    public skier(int id, long time) {
        this.id = id;
        this.time = time;
    }
}
