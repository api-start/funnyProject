package com.project.api.model;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Category {
    BUSINESS(UUID.fromString("61fba7c8-69fc-4bb6-945b-1ce4c485a24a")),
    categoria(UUID.fromString("8996ed33-1cb5-41d4-bd30-64c3b9277f51"));

    private final UUID id;

    private static final Map<UUID, Category> ID_TO_CATEGORY = Arrays.stream(values())
            .collect(Collectors.toMap(Category::getId, Function.identity()));

    Category(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public static Category fromString(String value) {
        if (value == null) {
            return null;
        }
        for (Category category : values()) {
            if (category.name().equalsIgnoreCase(value)) {
                return category;
            }
        }
        return null;
    }

    public static Category fromId(UUID id) {
        if (id == null) return null;
        return ID_TO_CATEGORY.get(id);
    }
}

