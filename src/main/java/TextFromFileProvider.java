import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextFromFileProvider implements TextProvider {
    public List <String> provideText(BufferedReader reader) throws FileNotFoundException{
        LinkedList <String> lines;
        boolean correctPath = false;

        try {
            lines = reader.lines().collect(Collectors.toCollection(LinkedList::new));
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }
}
