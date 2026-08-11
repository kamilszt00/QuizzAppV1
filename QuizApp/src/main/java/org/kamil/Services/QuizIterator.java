package org.kamil.Services;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Repository.RepositoryMap;


import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class QuizIterator {
    Scanner skan = new Scanner(System.in);
    public void iterQuiz(RepositoryMap<String,Question> questionRepo, RepositoryMap<String,Answer> answerRepo) {

        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Number of questions: %d ".formatted(questionRepo.size()) + ConsoleUI.RESET);
        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Please provide answers to the questions: " + ConsoleUI.RESET);
        System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "Leave blank to skip a question! " + ConsoleUI.RESET);
        questionIter(questionRepo,answerRepo);
        summary(questionRepo,answerRepo);

    }

    private void questionIter(RepositoryMap<String,Question> questionRepo, RepositoryMap<String,Answer> answerRepo) {

        questionRepo.forEach((id,Question) -> {


            if (answerRepo.getValue(id) == null || answerRepo.getValue(id).getAnswer().isBlank() ) {
                System.out.println(ConsoleUI.YELLOW + ConsoleUI.BOLD + "QuestionID: %s : ".formatted(id) + ConsoleUI.RESET + Question.content.getQuestion_text());
                String userAnswer = skan.nextLine();
                answerRepo.addToMap(id,new Answer(userAnswer, userAnswer.isEmpty() ));
            }

        });
    }


    private void summary(RepositoryMap<String,Question> questionRepo, RepositoryMap<String,Answer> answerRepo) {
        AtomicInteger AtmBlanked = new AtomicInteger();
        System.out.println("Here is summary of your answers: ");
        questionRepo.forEach((id,Question) -> {

            String prompt = "Question : " + Question.content.getQuestion_text() + " | Answer : " + answerRepo.getValue(id).getAnswer();
            if (answerRepo.getValue(id).getAnswer().isEmpty()) {
                System.out.println(ConsoleUI.RED + prompt + ConsoleUI.RESET);
                AtmBlanked.getAndIncrement();
            } else {
                System.out.println(prompt);
            }

        });
        int blanked = Integer.parseInt(AtmBlanked.toString());
        System.out.println("You've answered " + (questionRepo.size() - blanked) + " out of " + questionRepo.size() + ", " + blanked + " were skipped");
        System.out.println("Would you like to try answer skipped questions one more time?");
        if (skan.nextLine().equalsIgnoreCase("y")) {
            questionIter(questionRepo,answerRepo);
        }

    }





}
