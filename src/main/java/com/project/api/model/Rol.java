package com.project.api.model;

public class Rol {
    private String rolId;
    private String name;
    private String description;
    private String apiId;

    public Rol(String rolId, String name, String description, String apiId) {
        this.rolId = rolId;
        this.name = name;
        this.description = description;
        this.apiId = apiId;
    }

    public String getRolId() {
        return rolId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getApiId() {
        return apiId;
    }
}
