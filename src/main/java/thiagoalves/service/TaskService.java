package thiagoalves.service;

import java.io.IOException;

import main.java.thiagoalves.exception.TaskException;
import main.java.thiagoalves.exception.TaskNotFoundException;
import thiagoalves.exception.FieldNotFoundException;
import thiagoalves.model.Task;
import thiagoalves.repository.TaskRepository;

public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task add(String description) {
        try {
            return repository.save(description);   
        } catch (IOException | FieldNotFoundException e) {
            throw new TaskException("Erro ao adicionar tarefa.", e);
        }
    }

    public void update(int id, String description) {
        try {
            repository.update(id, description);
        } catch (IOException | FieldNotFoundException | TaskNotFoundException e) {
            throw new TaskException("Erro ao atualizar a tarefa.", e);
        }  
    }
}