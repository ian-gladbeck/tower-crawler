package exception;

public class AlreadyHasItemException extends RuntimeException {
    public AlreadyHasItemException(String message) {
        super(message);
    }
}
