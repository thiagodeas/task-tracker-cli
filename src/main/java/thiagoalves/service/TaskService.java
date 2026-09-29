package thiagoalves.service;

import java.io.IOException;

import thiagoalves.exception.FieldNotFoundException;
import thiagoalves.model.Task;
import thiagoalves.repository.TaskRepository;

public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task add(String description) throws IOException, FieldNotFoundException {
        return repository.save(description);
    }
}