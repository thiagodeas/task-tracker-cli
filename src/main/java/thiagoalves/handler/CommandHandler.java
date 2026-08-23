package thiagoalves.handler;

import thiagoalves.exception.InvalidCommandException;

public class CommandHandler {

    public CommandHandler() {}

    public void handle (String[] input) throws InvalidCommandException {
        String command = input[0];

        switch (command) {
            case "add":
                System.out.println("é add");
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
