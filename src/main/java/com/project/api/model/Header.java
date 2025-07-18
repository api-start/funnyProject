package com.project.api.model;

public class Header {
    private String id;
    private String name;
    private String description;
    private String exampleData;
    private String idEndpoint;

    public Header(String id, String name, String description, String exampleData, String idEndpoint) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exampleData = exampleData;
        this.idEndpoint = idEndpoint;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getExampleData() {
        return exampleData;
    }

    public String getIdEndpoint() {
        return idEndpoint;
    }
}
