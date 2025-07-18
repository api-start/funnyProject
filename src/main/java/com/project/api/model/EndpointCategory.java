package com.project.api.model;

public class EndpointCategory {
    private String id;
    private String name;
    private String idApi;

    private EndpointCategory(String id, String name, String idApi) {
        this.id = id;
        this.name = name;
        this.idApi = idApi;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdApi() {
        return idApi;
    }
}
