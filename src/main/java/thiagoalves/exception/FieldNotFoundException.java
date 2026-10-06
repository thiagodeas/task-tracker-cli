package thiagoalves.exception;

public class FieldNotFoundException extends Exception{
    public FieldNotFoundException(String message) {
        super(message);
    }

    public FieldNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
