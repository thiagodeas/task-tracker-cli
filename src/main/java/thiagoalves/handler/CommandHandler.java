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

    public void handle (String[] input) throws InvalidCommandException, MissingArgumentException, FieldNotFoundException {
        String command = input[0];

        switch (command) {
            case "add":
                if (input.length > 1 && !input[1].isBlank()) {
                    try {
                        taskService.add(input[1]);
                    } catch (Exception e) {
                        System.err.println("Erro: erro no command " + e.getMessage());
                    }
                } else {
                    throw new MissingArgumentException("O comando \"add\" precisa de uma descrição");
                }
                break;
            
            case "update":
                System.out.println("é update");
                break;

            case "delete":
                System.out.println("é delete");
                break;
            
            case "mark-in-progress":
                System.out.println("é markinprogress");
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
