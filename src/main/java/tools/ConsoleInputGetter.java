package tools;

import java.util.Scanner;

public class ConsoleInputGetter {

    public static String getStringInput(String message) {

        String input = null;
        boolean isCorrectInput = false;

        while(!isCorrectInput) {
            input = getStringInput();

            if (input.trim().length() > 0) {
                isCorrectInput = true;
            }
        }
        return input;
    }

    private static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
