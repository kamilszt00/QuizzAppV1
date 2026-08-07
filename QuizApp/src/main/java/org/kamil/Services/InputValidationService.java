package org.kamil.Services;

import java.util.List;

public class InputValidationService {
    public static boolean validateInput(String userInput, List<String> chapters) {
        return userInput != null  && userInput.matches("^\\d+(\\.\\d+){0,2}$") && chapters.contains(userInput);
    }
}
