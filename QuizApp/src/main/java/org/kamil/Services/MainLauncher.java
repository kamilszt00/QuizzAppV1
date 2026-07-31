package org.kamil.Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Model.Result;
import org.kamil.Repository.AnswerStore;
import org.kamil.Repository.QuestionLoader;
import org.kamil.Repository.QuestionStore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MainLauncher {
    public static void main(String[] args) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        QuestionStore questionsStorage = new QuestionStore();
        AnswerStore answerStorage = new AnswerStore();

        questionsStorage.setQuestionsStored(objectMapper.readValue(new File("src/main/resources/9.json"),new TypeReference<List<Question>>(){}));
        QuestionLoader.questionsLoading(questionsStorage.getQuestionsStored(),answerStorage.getAnswers());







//        questions.forEach(question -> {
//            System.out.println(question.content.getQuestion_text());
//            System.out.println("Please provide answer to the questions: ");
//            answers.add(new Answer(skan.nextLine(), question.getId()));
//        });
//
//
//
//        List<Result> results = new ArrayList<>(questions.size());
//        for (int i = 0; i < questions.size(); i++) {
//            results.add(new Result(questions.get(i).content.getQuestion_text(),answers.get(i).getAnswer(), answers.get(i).getQuestionID(),questions.get(i).content.getQuestion_type(), questions.get(i).grading_instructions.getCore_requirements(),questions.get(i).grading_instructions.getAcceptable_variations(),questions.get(i).grading_instructions.getStrictness_level()));
//        }
//
//        objectMapper.writeValue(new File("src/main/resources/Results/res1.json"), results);





    }


}
