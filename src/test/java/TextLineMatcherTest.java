import exceptions.IncorrectLineException;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TextLineMatcherTest {
    private TextLineMatcher matcher;
    private String message;

    @BeforeAll
    private void init() {
        matcher = new TextLineMatcher();
    }

    @Test
    public void incorrectLineExceptionWithProperMessageShouldBeThrown() {
        setMessage("Abcd", "efgh");
        Assertions.assertEquals("Wrong char at index '0'. Expected 'A', got 'e'.", message);
        setMessage("Abcd", "Abch");
        Assertions.assertEquals("Wrong char at index '3'. Expected 'd', got 'h'.", message);
        setMessage("Abcd", "");
        Assertions.assertEquals("Wrong char at index '0'. Expected 'A', got ''.", message);
        setMessage("Abcd", "Abcde");
        Assertions.assertEquals("Wrong char at index '4'. Expected '', got 'e'.", message);
    }

    @Test
    public void messageShouldReturnNullIfLinesMatch() {
        setMessage("Ab", "Ab");
        Assertions.assertEquals(null, message);
        Assertions.assertNull(message);
    }

    private void setMessage(String lineFromText, String lineFromUser) {
        try {
            matcher.matchLines(lineFromText, lineFromUser);
            message = null;
        } catch(
            IncorrectLineException e) {
            message = e.getMessage();
        }
    }

    @AfterEach
    private void destruct() {
        message = null;
    }
}
