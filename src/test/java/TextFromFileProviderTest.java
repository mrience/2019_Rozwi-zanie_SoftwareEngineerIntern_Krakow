import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

public class TextFromFileProviderTest {
    private TextProvider textProvider;
    private final String path = "/resources/text.txt";
    private BufferedReader reader;

    @BeforeEach
    private void init() {
        String canonicalPath = null;
        textProvider = new TextFromFileProvider();
        File f = new File(path);
        try {
            canonicalPath = f.getCanonicalPath();
            reader = new BufferedReader(new FileReader(canonicalPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    private void testProviderNotNull() {
        Assertions.assertNotNull(textProvider);
    }

    @Test
    private void testProviderReturnNotNullText() {
        try {
            Assertions.assertNotNull(textProvider.provideText(reader));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    private void assertProviderReturnRequiredText() {
        try {
            Assertions.assertTrue(textProvider.provideText(reader).get(0).startsWith("Ile razem dróg przebytych"));
            Assertions.assertTrue(textProvider.provideText(reader).get(25).startsWith("ocalić od zapomnienia"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
