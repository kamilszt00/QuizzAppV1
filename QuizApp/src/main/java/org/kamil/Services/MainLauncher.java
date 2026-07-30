package org.kamil.Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Model.Result;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainLauncher {
    public static void main(String[] args) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Question> questions = objectMapper.readValue(new File("src/main/resources/4.1.json"),new TypeReference<List<Question>>(){});
        Scanner skan = new Scanner(System.in);
        List<Answer> answers = new ArrayList<>();

        

        questions.forEach(question -> {
            System.out.println(question.content.getQuestion_text());
            System.out.println("Please provide answer to the questions: ");
            answers.add(new Answer(skan.nextLine(), question.getId()));
        });



        List<Result> results = new ArrayList<>(questions.size());
        for (int i = 0; i < questions.size(); i++) {
            results.add(new Result(questions.get(i).content.getQuestion_text(),answers.get(i).getAnswer(), answers.get(i).getQuestionID()));
        }

        objectMapper.writeValue(new File("src/main/resources/Results/res1.json"), results);





    }


}
