package org.kamil.Services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.kamil.Repository.AnswerRepository;

import org.kamil.Repository.QuestionRepository;
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
        QuestionRepository questionsStorage = new QuestionRepository();
        AnswerRepository answerStorage = new AnswerRepository();
        ResultRepository resultRepository = new ResultRepository();

        QuizzGreeter.greetUser();
        boolean keepQuizzing = true;

        while (keepQuizzing) {
            String chapter = ChapterSelectionService.chapterSelector("src/main/resources/chapters");
            File chapterFile = new File("src/main/resources/chapters/%s.json".formatted(chapter));
            questionsStorage.setQuestionsStored(jsonFileService.mapQuestions(chapterFile));
            QuizIterator.iterQuiz(questionsStorage.getQuestionsStored(),answerStorage);
            ResultService.resultMapper(questionsStorage,answerStorage, resultRepository);
            jsonFileService.mapResults(resultRepository.getResultsStored());
            keepQuizzing = NextQuiz.askForNextQuiz();
        }
    }



}
