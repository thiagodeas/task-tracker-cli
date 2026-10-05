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

    public void update(int id, String description) {
        try {
            repository.update(id, description);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }  
    }
}