package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputGetter {

    private final static String NO_FILE_ENTERED_MESSAGE = "No file name entered.";

    // displays message and requests file name until it is entered
    public static String requestUserInputWithMessage(String message) {
        String inputString = null;
        boolean isInputCorrect = false;

        while (!isInputCorrect) {
            System.out.println(message);
            inputString = readUserInput();

            if (isNullOrEmptyOrWhiteSpace(inputString)) {
                System.out.println(NO_FILE_ENTERED_MESSAGE);
            } else {
                isInputCorrect = true;
            }
        }

        return inputString;
    }

    // reads user input
    private static String readUserInput() {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;

        try {
            inputString = inputReader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return inputString;
    }

    // checks if file name is empty
    private static  boolean isNullOrEmptyOrWhiteSpace(final String string) {
        return string == null || string.isEmpty() || string.trim().isEmpty();
    }
}
