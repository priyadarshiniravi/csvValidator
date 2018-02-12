package Exceptions;

public class EmptyHeaderException extends HeaderInvalidException{
    
    public static final String THERE_IS_NO_HEADERS_OR_EMPTY_FILE = "There is no headers or Empty File";
    
    public EmptyHeaderException() {
        super(THERE_IS_NO_HEADERS_OR_EMPTY_FILE);
    }
}
