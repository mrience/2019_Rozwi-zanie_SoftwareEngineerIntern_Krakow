import exceptions.IncorrectLineException;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KeyboardTeacher {
    private Scanner sc = new Scanner(System.in);
    private TextLineMatcher matcher = new TextLineMatcher();
    private List <String> linesToTeach;


    public void teachKeyboard() {
        provideFileLines();
        System.out.println("Follow the lines now!");
        boolean correct = false;
        Scanner scanner = new Scanner(System.in);
        for (String lineFromText : linesToTeach) {
            correct = false;
            System.out.println(lineFromText.trim());
            while (!correct) {
                try {
                    matcher.matchLines(lineFromText.trim(), scanner.nextLine());
                    correct = true;
                } catch (IncorrectLineException e) {
                    System.out.println(e.getMessage() + "\nTry again!");
                }
            }
        }
        scanner.close();
        System.out.println("Congratulations!");
    }

    private void provideFileLines() {
        System.out.println("Provide path to Your file:");
        boolean correctPath = false;
        BufferedReader reader = null;
        while (!correctPath) {
            try {
                reader = new BufferedReader(new FileReader(new File(sc.nextLine())));
                linesToTeach = new TextFromFileProvider().provideText(reader);
                correctPath = true;
            } catch (FileNotFoundException e) {
                System.out.println("Wrong path, try again!");
            }
        }
    }
}
