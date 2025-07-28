package com.project.api.repository.interfaces;

import com.project.api.model.RequestMethod;

import java.util.List;

public interface RequestMethodRepository {
    List<String> findAllMethodsNames();
    void create(RequestMethod requestMethod);
}
