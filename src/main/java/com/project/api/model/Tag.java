package com.project.api.model;

public class Tag {
    private String tagId;
    private String name;

    public Tag(String tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public String getTagId() {
        return tagId;
    }

    public String getName() {
        return name;
    }
}
