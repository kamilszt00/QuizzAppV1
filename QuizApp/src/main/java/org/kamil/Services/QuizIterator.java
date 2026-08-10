package org.kamil.Services;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Repository.RepositoryMap;


import java.util.Scanner;

public class QuizIterator {

    public static void iterQuiz(RepositoryMap<String,Question> questionRepo, RepositoryMap<String,Answer> answerRepo) {
        Scanner skan = new Scanner(System.in);
        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Number of questions: %d ".formatted(questionRepo.size()) + ConsoleUI.RESET);


        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Please provide answers to the questions: " + ConsoleUI.RESET);
        questionRepo.forEach((id,Question) -> {

            System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "QuestionID: %s : ".formatted(id) + ConsoleUI.RESET + Question.content.getQuestion_text());
            answerRepo.addToMap(id,new Answer(skan.nextLine()));
        });

    }
}
