package Exceptions;

import java.util.List;


public class InvalidHeaderMissingArgument extends HeaderInvalidException {
    public InvalidHeaderMissingArgument(List<String> missingHeaders) {
        super(String.format("invalid header missing arguments %s", String.join( ",", missingHeaders)));
    }
}
