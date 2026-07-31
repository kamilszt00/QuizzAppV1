package org.kamil.Repository;

import org.kamil.Model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    private List<Question> questionsStored = new ArrayList<>();

    public List<Question> getQuestionsStored() {
        return questionsStored;
    }

    public void setQuestionsStored(List<Question> questionsStored) {
        this.questionsStored = questionsStored;
    }
}
