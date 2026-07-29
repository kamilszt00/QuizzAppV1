package org.kamil.Model;

public class Result {
    private String question;
    private String answer;
    private String id;

    public Result(String question, String answer, String id) {
        this.answer = answer;
        this.question = question;
        this.id =  id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getId() {
        return id;
    }
}
