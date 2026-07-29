package org.kamil.Model;

public class Answer {
    private String answer;
    private String questionID;


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public Answer(String answer, String questionID) {
        this.answer = answer;
        this.questionID = questionID;
    }
}
