package com.project.api.model;

public class Parameter {
    private String tokenId;
    private String paramName;
    private String description;
    private String exampleData;
    private String id_endpoint;

    public Parameter(String tokenId, String paramName, String description, String exampleData, String id_endpoint) {
        this.tokenId = tokenId;
        this.paramName = paramName;
        this.description = description;
        this.exampleData = exampleData;
        this.id_endpoint = id_endpoint;
    }

    public String getTokenId() {
        return tokenId;
    }

    public String getParamName() {
        return paramName;
    }

    public String getDescription() {
        return description;
    }

    public String getExampleData() {
        return exampleData;
    }

    public String getId_endpoint() {
        return id_endpoint;
    }
}
