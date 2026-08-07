package org.kamil.Services;

import java.util.Objects;
import java.util.Scanner;

public class NextQuiz {
    public static boolean askForNextQuiz() {
        Scanner skan = new Scanner(System.in);
        System.out.println("Another quizz Y/n");
        String decision = skan.nextLine();
        return Objects.equals(decision, "Y") || Objects.equals(decision, "y");
    }
}
