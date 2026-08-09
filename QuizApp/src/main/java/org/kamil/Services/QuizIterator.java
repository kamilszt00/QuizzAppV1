package org.kamil.Services;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;


import java.util.Map;
import java.util.Scanner;

public class QuizIterator {

    public static void iterQuiz(Map<String,Question> questionMap, Map<String,Answer> answerMap) {
        Scanner skan = new Scanner(System.in);
        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Number of questions: %d ".formatted(questionMap.size()) + ConsoleUI.RESET);


        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Please provide answers to the questions: " + ConsoleUI.RESET);
        questionMap.forEach((id,Question) -> {

            System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "QuestionID: %s : ".formatted(id) + ConsoleUI.RESET + Question.content.getQuestion_text());
            answerMap.put(id,new Answer(skan.nextLine()));
        });

    }
}
