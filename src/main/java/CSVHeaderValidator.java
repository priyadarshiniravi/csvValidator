import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class CSVHeaderValidator {
    private final List<String> requiredHeader;
    
    public CSVHeaderValidator(List<String> requiredHeader) {
        this.requiredHeader = requiredHeader;
    }
    
    public List<String> validate(String headerString) {
        if(headerString.isEmpty())
        {
            throw new EmptyHeaderException();
        }
        List<String> headers = asList(headerString.trim().split("\\s*,\\s*"));
        if(!headers.containsAll(requiredHeader))
        {
            List<String> difference = requiredHeader.stream()
                    .filter(i -> !headers.contains(i))
                    .collect (Collectors.toList());
            throw new InvalidHeaderMissingArgument(difference);
        }
        return headers;
    }
}
