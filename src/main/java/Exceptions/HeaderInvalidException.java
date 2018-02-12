package Exceptions;

public class HeaderInvalidException extends RuntimeException {
    public HeaderInvalidException(String message) {
        super(message);
    }
}
