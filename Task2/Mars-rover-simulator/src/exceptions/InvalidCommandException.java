package exceptions;

/** Thrown when a provided/parsed command is invalid/unrecognized. */
public class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }
}
