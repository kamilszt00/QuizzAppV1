package org.kamil.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kamil.Model.Question;
import org.kamil.Model.Result;
import org.kamil.Repository.RepositoryMap;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JsonFileService {
    private final ObjectMapper objectMapper;

    public JsonFileService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public List<Question> mapQuestions (File chapterFile) throws IOException {
        return objectMapper.readValue(chapterFile, new TypeReference<>() {});

    }


    public Map<String,Question> mappingQuestions (File chapterFile) throws IOException {
        Map<String,Question> qMap = new LinkedHashMap<>();
        List<Question> q = objectMapper.readValue(chapterFile, new TypeReference<>() {});
        q.forEach(Q -> {
            qMap.put(Q.getId(),Q);
        });
        return qMap;
    }

    public void mapResults(RepositoryMap<String,Result> resultRepo) throws IOException {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy|HH:mm:ss"));
        List<Result> results = new ArrayList<>();
        resultRepo.forEach((id,result) -> results.add(result));
        objectMapper.writeValue(new File("/home/kamilxcv/Downloads/quiz%s.json".formatted(date)), results);
        System.out.println(ConsoleUI.YELLOW + "Results of quiz saved to Downloads with name: " + date + ConsoleUI.RESET);
    }





}
