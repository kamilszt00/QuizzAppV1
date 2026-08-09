package org.kamil.Services;


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



        RepositoryMap<String,Question> questionMapRepo = new RepositoryMap<>();
        RepositoryMap<String, Answer> answerMapRepo = new RepositoryMap<>();
        RepositoryMap<String, Result> resultMapRepo = new RepositoryMap<>();

        QuizzGreeter.greetUser();
        boolean keepQuizzing = true;

        while (keepQuizzing) {
            String chapter = ChapterSelectionService.chapterSelector("src/main/resources/chapters");
            File chapterFile = new File("src/main/resources/chapters/%s.json".formatted(chapter));
            questionMapRepo.setMapOfStored(jsonFileService.mappingQuestions(chapterFile));
            QuizIterator.iterQuiz(questionMapRepo.getMapOfStored(), answerMapRepo.getMapOfStored());

            ResultService.resultMapper(questionMapRepo.getMapOfStored(),answerMapRepo.getMapOfStored(),resultMapRepo.getMapOfStored());
            jsonFileService.mapResults(resultMapRepo.getMapOfStored());
            keepQuizzing = NextQuiz.askForNextQuiz();
        }
    }



}
