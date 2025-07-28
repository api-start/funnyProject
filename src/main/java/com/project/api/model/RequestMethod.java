package com.project.api.model;

import com.github.f4b6a3.uuid.UuidCreator;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum RequestMethod {
    GET(UuidCreator.fromString("01984ed7-7427-7e95-8b46-50a7bbebf837")),
    POST(UuidCreator.fromString("01984ed7-7427-7e95-8b47-9275cbc6bfd4")),
    PUT(UuidCreator.fromString("01984ed7-7427-7e95-8b48-57c5f85f2f78")),
    DELETE(UuidCreator.fromString("01984ed7-7427-7e95-8b49-57f28cb0630c"));

    private static final Map<UUID, RequestMethod> ID_TO_METHOD = Arrays.stream(values())
            .collect(Collectors.toMap(RequestMethod::getId, Function.identity()));

    private final UUID id;


    RequestMethod(UUID id) {
        this.id = id;
    }

    public static RequestMethod fromName(String value) {
        if (value == null) {
            return null;
        }
        for (RequestMethod requestMethod : values()) {
            if (requestMethod.name().equalsIgnoreCase(value)) {
                return requestMethod;
            }
        }
        return null;
    }

    public static RequestMethod fromId(UUID id) {
        if (id == null) return null;
        return ID_TO_METHOD.get(id);
    }

    public UUID getId() {
        return id;
    }
}
