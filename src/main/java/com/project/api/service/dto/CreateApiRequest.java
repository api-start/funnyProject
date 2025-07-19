package com.project.api.service.dto;

import com.project.api.model.Category;
import com.project.api.model.annotation.NotNullNotWhitespace;
import com.project.api.service.InvalidCategoryException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateApiRequest {
    @NotBlank
    @Size(min = 8, message = "Api name must be min 9 characters")
    @Size(max = 100, message = "Api name must be max 100 characters")
    private String name;

    @NotNullNotWhitespace
    @Size(min = 5, message = "Url must be min 5 char")
    @Size(max = 100, message = "Url must be max 5 char")
    private String urlBase;

    @NotNull
    @Size(max = 100, message = "Description must be max 100 char")
    private String description;

    @NotNullNotWhitespace
    @Size(min = 1, message = "Version must be min 1 char")
    @Size(max = 10, message = "Version must be max 10 char")
    private String version;

    @NotNull(message = "Invalid category")
    private Category category;

    public CreateApiRequest(String name, String urlBase, String description, String version, String category) {
        this.name = name;
        this.urlBase = urlBase;
        this.description = description;
        this.version = version;
        this.category = validateCategory(category);
    }

    private Category validateCategory(String category){
        Category cat = null;
        try {
            cat = Category.valueOf(category); // need the catch otherwise would throw exception
        }catch (IllegalArgumentException e){
        }
        return cat;
    }
}
