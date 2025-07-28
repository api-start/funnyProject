package com.project.api.model;

import com.github.f4b6a3.uuid.UuidCreator;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Category {
    SPORTS(UuidCreator.fromString("01984e80-3f13-7d61-9f41-c8f5686ab4f3")),
    FINANCE(UuidCreator.fromString("01984e80-3f13-7d61-9f42-79ca779c0827")),
    BUSINESS(UuidCreator.fromString("01984e80-3f13-7d61-9f43-e808cd34e3c8")),
    DATA(UuidCreator.fromString("01984e80-3f13-7d61-9f44-7e7331e9d301")),
    ENTERTAINMENT(UuidCreator.fromString("01984e80-3f14-7d61-ab54-98b059bde9e4")),
    TRAVEL(UuidCreator.fromString("01984e80-3f14-7d61-ab55-b7e39f97849e")),
    LOCATION(UuidCreator.fromString("01984e80-3f14-7d61-ab56-45f0f8c2ac6a")),
    SCIENCE(UuidCreator.fromString("01984e80-3f14-7d61-ab57-07e78b765c9b")),
    ARTIFICIAL_INTELLIGENCE(UuidCreator.fromString("01984e80-3f14-7d61-ab58-26c3d3f07168")),
    FOOD(UuidCreator.fromString("01984e80-3f14-7d61-ab59-80b641b3f0d8")),
    TRANSPORTATION(UuidCreator.fromString("01984e80-3f14-7d61-ab5a-98cd8461ea93")),
    MUSIC(UuidCreator.fromString("01984e80-3f14-7d61-ab5b-a6b5a24ef3a0")),
    TOOLS(UuidCreator.fromString("01984e80-3f14-7d61-ab5c-5973a161670b")),
    WEATHER(UuidCreator.fromString("01984e80-3f14-7d61-ab5d-97fa5ec13506")),
    GAMING(UuidCreator.fromString("01984e80-3f15-7d5e-ad36-3eacb8ec4788")),
    SMS(UuidCreator.fromString("01984e80-3f15-7d5e-ad37-e6b223d23e4a")),
    EVENTS(UuidCreator.fromString("01984e80-3f15-7d5e-ad38-438158eef745")),
    HEALTH_AND_FITNESS(UuidCreator.fromString("01984e80-3f15-7d5e-ad39-6d11181d419f")),
    TEXT_ANALYSIS(UuidCreator.fromString("01984e80-3f15-7d5e-ad3a-9310e776a11a")),
    VISUAL_RECOGNITION(UuidCreator.fromString("01984e80-3f15-7d5e-ad3b-1d50088a8065"));

    private static final Map<UUID, Category> ID_TO_CATEGORY = Arrays.stream(values())
            .collect(Collectors.toMap(Category::getId, Function.identity()));
    private final UUID id;


    Category(UUID id) {
        this.id = id;
    }

    public static Category fromName(String value) {
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

    public UUID getId() {
        return id;
    }
}

