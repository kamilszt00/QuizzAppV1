package org.kamil.Repository;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;

import java.util.List;
import java.util.Scanner;

public class QuestionLoader {
    public static void questionsLoading(List<Question> questionsList, List<Answer> answersList) {
        Scanner skan = new Scanner(System.in);
        System.out.println("Please provide answers to the questions");
        questionsList.forEach( Question -> {
            System.out.println(Question.content.getQuestion_text());
            answersList.add(new Answer(skan.nextLine(),Question.getId()));


        });
    }




}
