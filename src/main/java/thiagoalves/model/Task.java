package thiagoalves.Model;

import java.time.LocalDateTime;

import thiagoalves.Enum.Status;

public class Task {
    private static int contador = 0;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description, Status status) {
        this.id = ++contador;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }
    
    public LocalDateTime getCreatedDateTime() {
        return createdAt;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedAt;
    }
}