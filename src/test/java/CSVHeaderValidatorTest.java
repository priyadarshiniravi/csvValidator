import Exceptions.EmptyHeaderException;
import Exceptions.InvalidHeaderMissingArgument;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CSVHeaderValidatorTest {
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    
    private final List<String> requiredHeader = asList("Header1", "Header2", "Header3");
    
    @Test
    public void shouldThrowHeaderInvalidExceptionIfHeaderIsEmpty() throws Exception {
        expectedException.expect(EmptyHeaderException.class);
        expectedException.expectMessage("There is no headers or Empty File");
        String headerString = "";
        CSVHeaderValidator csvHeaderValidator = new CSVHeaderValidator(requiredHeader);
    
        csvHeaderValidator.validate(headerString);
    }
    
    @Test
    public void shouldReturnHeaderListForValidHeaderCommaSeperated() throws Exception {
        String headerString = "Header1,Header2,Header3";
        CSVHeaderValidator csvHeaderValidator = new CSVHeaderValidator(requiredHeader);
    
        List<String> headers = csvHeaderValidator.validate(headerString);
        
        assertThat(headers).containsExactly("Header1", "Header2", "Header3");
    }
    
    @Test
    public void shouldReturnHeaderListForValidHeaderCommaSeperatedWithSpacesInBetween() throws Exception {
        String headerString = "Header1 , Header2 , Header3";
        CSVHeaderValidator csvHeaderValidator = new CSVHeaderValidator(requiredHeader);
    
        List<String> headers = csvHeaderValidator.validate(headerString);
        
        assertThat(headers).containsExactly("Header1", "Header2", "Header3");
    }
    
    @Test
    public void shouldReturnHeaderListForValidHeaderCommaSeperatedWithSpacesAtEnd() throws Exception {
        String headerString = "Header1 , Header2 , Header3 ";
        CSVHeaderValidator csvHeaderValidator = new CSVHeaderValidator(requiredHeader);
    
        List<String> headers = csvHeaderValidator.validate(headerString);
        
        assertThat(headers).containsExactly("Header1", "Header2", "Header3");
    }
    
    @Test
    public void shouldThrowInvalidHeaderIfHeadersAreMissing() throws Exception {
        expectedException.expect(InvalidHeaderMissingArgument.class);
        expectedException.expectMessage("invalid header missing arguments Header3");
        String headerString = "Header1 , Header2";
        CSVHeaderValidator csvHeaderValidator = new CSVHeaderValidator(requiredHeader);

        csvHeaderValidator.validate(headerString);
    }
}