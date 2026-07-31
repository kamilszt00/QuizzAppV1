package org.kamil.Services;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Repository.AnswerStore;

import java.util.List;
import java.util.Scanner;

public class QuizIterator {

    public static void iterQuiz(List<Question> questionList, AnswerStore answerStore) {
        Scanner skan = new Scanner(System.in);
        System.out.println("Please provide answers to the questions: ");
        questionList.forEach(Question -> {
            System.out.println(Question.content.getQuestion_text());
            answerStore.getAnswers().add(new Answer(skan.nextLine(), Question.getId()));
        });

    }
}
