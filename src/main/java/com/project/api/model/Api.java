package com.project.api.model;
import java.time.LocalDate;
import java.util.UUID;

public class Api {
    private UUID id;
    private String name;
    private String urlBase;
    private String description;
    private String version;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private UUID accountId;
    private Category category;

    private Api(UUID id, String name, String urlBase, String description, String version, LocalDate createdDate, LocalDate updatedDate, UUID accountId, Category category) {
        this.id = id;
        this.name = name;
        this.urlBase = urlBase;
        this.description = description;
        this.version = version;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.accountId = accountId;
        this.category = category;
    }

    public static Api createNew(UUID id, String name, String urlBase, String description, String version, LocalDate createdDate, LocalDate updatedDate, UUID accountId, Category category) {
        return new Api(
                id,
                name,
                urlBase,
                description,
                version,
                LocalDate.now(),
                LocalDate.now(),
                accountId,
                category
        );
    }

    public static Api fromDatabase(UUID id, String name, String urlBase, String description, String version, LocalDate createdDate, LocalDate updatedDate, UUID accountId, Category category) {
        return new Api(id,name,urlBase,description,version,createdDate,updatedDate,accountId,category);
    }

    public void update(String urlBase, String description, String version){
        if (!urlBase.isBlank()){
            this.urlBase = urlBase;
        }
        if (!urlBase.isEmpty()){
            this.description = urlBase;
        }
        if (!urlBase.isBlank()){
            this.version = urlBase;
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public Category getCategory() {
        return category;
    }
}
