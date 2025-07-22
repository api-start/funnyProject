package com.project.api.repository.interfaces;

import com.project.api.model.Api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApiRepository {
    List<Api> findAll();
    Optional<Api> findById(UUID id);
    Optional<Api> findByName(String name);
    int update(Api api);
    int save(Api api);
}
