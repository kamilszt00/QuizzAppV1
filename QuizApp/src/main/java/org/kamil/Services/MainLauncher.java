package org.kamil.Services;


import org.kamil.Config.ConfigService;
import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Model.Result;
import org.kamil.Repository.RepositoryMap;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainLauncher {
    public static void main(String[] args) throws IOException {

        run();
    }



    private static void run() throws IOException {
        JsonFileService jsonFileService = new JsonFileService();



        boolean keepQuizzing = true;

        ConfigService config= new ConfigService();

        QuizzGreeter.greetUser();

//        while (keepQuizzing) {
//            RepositoryMap<String,Question> questionMapRepo = new RepositoryMap<>();
//            RepositoryMap<String, Answer> answerMapRepo = new RepositoryMap<>();
//            RepositoryMap<String, Result> resultMapRepo = new RepositoryMap<>();
//
//            String chapter = ChapterSelectionService.chapterSelector("src/main/resources/chapters");
//            File chapterFile = new File("src/main/resources/chapters/%s.json".formatted(chapter));
//            questionMapRepo.setMapOfStored(jsonFileService.mappingQuestions(chapterFile));
//            QuizIterator.iterQuiz(questionMapRepo, answerMapRepo);
//            // add skipping + reviewing options
//            ResultService.resultMapper(questionMapRepo,answerMapRepo,resultMapRepo);
//
//            jsonFileService.mapResults(resultMapRepo);
//            keepQuizzing = NextQuiz.askForNextQuiz();
//        }
    }



}
