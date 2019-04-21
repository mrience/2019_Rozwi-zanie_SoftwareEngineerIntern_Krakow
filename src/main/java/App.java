import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        final long startTime = System.currentTimeMillis();
        new KeyboardTeacher().teachKeyboard();
        final long elapsedTimeMillis = System.currentTimeMillis() - startTime;
        System.out.println("It took " + elapsedTimeMillis/1000 + "s.");
    }
}
