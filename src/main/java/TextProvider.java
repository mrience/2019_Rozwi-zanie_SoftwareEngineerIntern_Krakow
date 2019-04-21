import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public interface TextProvider {
    List <String> provideText(BufferedReader input) throws FileNotFoundException;
}
