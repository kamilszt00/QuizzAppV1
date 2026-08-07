package org.kamil.Services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kamil.Model.Question;
import org.kamil.Model.Result;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileService {
    private final ObjectMapper objectMapper;

    public JsonFileService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public List<Question> mapQuestions (File chapterFile) throws IOException {
        return objectMapper.readValue(chapterFile, new TypeReference<>() {});
    }

    public void mapResults(List<Result> results) throws IOException {
        objectMapper.writeValue(new File("src/main/resources/Results/result.json"), results);
    }

}
