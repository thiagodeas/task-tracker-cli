package thiagoalves.handler;

import thiagoalves.exception.FieldNotFoundException;
import thiagoalves.exception.InvalidCommandException;
import thiagoalves.exception.MissingArgumentException;
import thiagoalves.service.TaskService;

public class CommandHandler {

    private final TaskService taskService;

    public CommandHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public void handle (String[] input) {
        String command = input[0];

        switch (command) {
            case "add":
                if (input.length > 1 && !input[1].isBlank()) {
                    try {
                        taskService.add(input[1]);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                } else {
                    throw new MissingArgumentException("O comando \"add\" precisa de uma descrição");
                }
                break;
            
            case "update":
                if (input.length > 2 && !input[2].isBlank()) {
                    try {  
                        int id = Integer.parseInt(input[1]);
                        taskService.update(id, input[2]);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                break;

            case "delete":
                if (input.length > 1 && !input[1].isBlank()) {
                    try {
                        int id = Integer.parseInt(input[1]);
                        taskService.delete(id);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                break;
            
            case "mark-in-progress":
                if (input.length > 1 && !input[1].isBlank()) {
                    try {
                        int id = Integer.parseInt(input[1]);
                        taskService.markInProgress(id);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                break;

            case "mark-done":
                System.out.println("é markdone");
                break;

            case "list":
                if(input.length > 1) {
                    switch (input[1]) {
                        case "done":
                            System.out.println("é list done");
                            break;

                        case "todo":
                            System.out.println("é list todo");
                            break;

                        case "in-progress":
                            System.out.println("é list in-progress");
                            break;
                    
                        default:
                            throw new InvalidCommandException("Comando inválido");
                    }
                } else {
                    System.out.println("é só list");
                }
                break;

            default:
                throw new InvalidCommandException("Comando inválido");
        }
    }
}
