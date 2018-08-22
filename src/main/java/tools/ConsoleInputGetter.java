package tools;

import java.util.Scanner;

public class ConsoleInputGetter {
    private static final String EXIT = ".exit";

    public static String getStringInput() {
        String input = null;
        boolean isCorrectInput = false;

        while(!isCorrectInput) {
            input = getUserInput();

            if (input.equals(EXIT)) {
                System.exit(0);
            }
            if (input.trim().length() > 0) {
                isCorrectInput = true;
            }
        }
        return input;
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
