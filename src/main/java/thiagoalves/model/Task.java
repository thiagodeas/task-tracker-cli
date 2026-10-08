package thiagoalves.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import thiagoalves.enums.Status;

public class Task {

    private static final ZoneId ZONE_BR = ZoneId.of("America/Sao_Paulo");

    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now(ZONE_BR);
        this.updatedAt = LocalDateTime.now(ZONE_BR);
    }

    public Task (int id, String description, Status status, String createdAt, String updatedAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.parse(createdAt);
        this.updatedAt = LocalDateTime.parse(updatedAt);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public Status setStatus(Status status) {
        return this.status = status;
    }
    
    public LocalDateTime getCreatedDateTime() {
        return createdAt;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedAt;
    }

    public void setUpdatedDateTime() {
        this.updatedAt = LocalDateTime.now(ZONE_BR); 
    }

}