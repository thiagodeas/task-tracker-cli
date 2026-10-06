package thiagoalves;

import thiagoalves.service.TaskService;
import thiagoalves.exception.FieldNotFoundException;
import thiagoalves.exception.InvalidCommandException;
import thiagoalves.handler.CommandHandler;
import thiagoalves.repository.TaskRepository;

public class App {
    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();

        TaskService taskService = new TaskService(taskRepository);

        CommandHandler commandHandler = new CommandHandler(taskService);
        
        try {
            commandHandler.handle(args);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            System.exit(1);
        } 
    }
}
