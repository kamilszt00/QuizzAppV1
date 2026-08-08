package org.kamil.Services;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Repository.AnswerRepository;

import java.util.List;
import java.util.Scanner;

public class QuizIterator {

    public static void iterQuiz(List<Question> questionList, AnswerRepository answerRepository) {
        Scanner skan = new Scanner(System.in);
        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Number of questions: %d ".formatted(questionList.size()) + ConsoleUI.RESET);


        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Please provide answers to the questions: " + ConsoleUI.RESET);
        questionList.forEach(Question -> {
            System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Question %d: ".formatted((questionList.indexOf(Question) + 1)) + ConsoleUI.RESET + Question.content.getQuestion_text());
            answerRepository.addAnswer(Question.getId(),new Answer(skan.nextLine()));
        });

    }
}
