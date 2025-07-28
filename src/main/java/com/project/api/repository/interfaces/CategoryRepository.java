package com.project.api.repository.interfaces;

import com.project.api.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<String> findAllCategoriesNames();
    void create(Category category);
}
