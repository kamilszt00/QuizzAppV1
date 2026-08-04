package org.kamil.Services;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kamil.Model.Question;
import org.kamil.Model.Result;
import org.kamil.Repository.AnswerRepository;

import org.kamil.Repository.QuestionRepository;
import org.kamil.Repository.ResultRepository;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainLauncher {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        QuestionRepository questionsStorage = new QuestionRepository();
        AnswerRepository answerStorage = new AnswerRepository();
        ResultRepository resultRepository = new ResultRepository();

        QuizzGreeter.greetUser();
        String chapter = ChapterSelectionService.chapterSelector("src/main/resources/chapters");
        File chapterFile = new File("src/main/resources/chapters/%s.json".formatted(chapter));

        questionsStorage.setQuestionsStored(objectMapper.readValue(chapterFile,new TypeReference<List<Question>>(){}));
        QuizIterator.iterQuiz(questionsStorage.getQuestionsStored(),answerStorage);

        ResultService.resultMapper(questionsStorage,answerStorage, resultRepository);


        objectMapper.writeValue(new File("src/main/resources/Results/result.json"), resultRepository.getResultsStored());



























    }


}
