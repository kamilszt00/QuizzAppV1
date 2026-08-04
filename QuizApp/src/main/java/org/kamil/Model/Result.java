package org.kamil.Model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Result {

    private String answer;
    @JsonUnwrapped
    private Question question;


    public Result(String answer, Question question) {
        this.answer = answer;
        this.question = question;

    }

    public String getAnswer() {
        return answer;
    }

    public Question getQuestion() {
        return question;
    }
}
