package thiagoalves;

import thiagoalves.handler.CommandHandler;

public class App {
    public static void main(String[] args) {

        CommandHandler commandHandler = new CommandHandler();
        try {
            commandHandler.handle(args);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            System.exit(1);
        }
        
    }
}
