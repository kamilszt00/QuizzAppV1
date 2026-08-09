package org.kamil.Services;


import org.kamil.Model.Question;
import org.kamil.Repository.AnswerRepository;

import org.kamil.Repository.Repository;
import org.kamil.Repository.ResultRepository;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainLauncher {
    public static void main(String[] args) throws IOException {

        run();
    }



    private static void run() throws IOException {
        JsonFileService jsonFileService = new JsonFileService();

        Repository<Question> questionStore = new Repository<>();
        AnswerRepository answerStorage = new AnswerRepository();
        ResultRepository resultRepository = new ResultRepository();

        QuizzGreeter.greetUser();
        boolean keepQuizzing = true;

        while (keepQuizzing) {
            String chapter = ChapterSelectionService.chapterSelector("src/main/resources/chapters");
            File chapterFile = new File("src/main/resources/chapters/%s.json".formatted(chapter));
            questionStore.setListOfStored(jsonFileService.mapQuestions(chapterFile));
            QuizIterator.iterQuiz(questionStore.getListOfStored(),answerStorage);
            ResultService.resultMapper(questionStore,answerStorage,resultRepository);
            jsonFileService.mapResults(resultRepository.getResultsStored());
            keepQuizzing = NextQuiz.askForNextQuiz();
        }
    }



}
