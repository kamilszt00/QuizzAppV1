package org.kamil.Services;

public class InputValidationService {
    public static boolean validateInput(String userInput) {
        return userInput != null  && userInput.matches("^\\d+(\\.\\d+){0,2}$");
    }
}
