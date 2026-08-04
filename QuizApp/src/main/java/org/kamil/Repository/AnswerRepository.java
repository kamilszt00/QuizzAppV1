package org.kamil.Repository;

import org.kamil.Model.Answer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class AnswerRepository {




    Map<String, Answer> answers = new LinkedHashMap<String, Answer>();


    public Map<String,Answer> getAnswers() {
        return answers;
    }


    public void addAnswer(String s, Answer a) {
        answers.put(s,a);
    }


}
