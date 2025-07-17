package com.project.api.model;

public enum Category {
    BUSINESS(1);

    private int id;

    Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
