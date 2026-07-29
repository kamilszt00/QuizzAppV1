package org.kamil.Services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kamil.Model.Question;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainLauncher {
    public static void main(String[] args) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Question> questions = objectMapper.readValue(new File("src/main/resources/4.1.json"),new TypeReference<List<Question>>(){});
        Scanner skan = new Scanner(System.in);


        for (Question q : questions) {
            System.out.println(q.content.getQuestion_text());
            System.out.println("Please provide answer to the questions: ");
            q.setAnswer(skan.nextLine());
        }





        // checking input
        for (Question q : questions) {
            System.out.println(q.content.getQuestion_text());
            System.out.println(q.getAnswer());
        }


    }


}
