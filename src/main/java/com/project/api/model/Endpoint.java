package com.project.api.model;

public class Endpoint {
    private String id;
    private String name;
    private String description;
    private String urlNoBase;
    private RequestMethod requestMethod;
    private Rol authorizationRol;
    private EndpointCategory endpointCategory;
    private String idApi;

    public Endpoint(String id, String name, String description, String urlNoBase, RequestMethod requestMethod, Rol authorizationRol, EndpointCategory endpointCategory, String idApi) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlNoBase = urlNoBase;
        this.requestMethod = requestMethod;
        this.authorizationRol = authorizationRol;
        this.endpointCategory = endpointCategory;
        this.idApi = idApi;
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

    public String getUrlNoBase() {
        return urlNoBase;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public Rol getAuthorizationRol() {
        return authorizationRol;
    }

    public EndpointCategory getEndpointCategory() {
        return endpointCategory;
    }

    public String getIdApi() {
        return idApi;
    }
}
