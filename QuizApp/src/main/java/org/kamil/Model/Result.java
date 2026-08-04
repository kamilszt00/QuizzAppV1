package org.kamil.Model;

public class Result {

    private String answer;
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
