package org.kamil.Model;

public class Answer {
    private String answer;
    private boolean isAnswered;


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }




    public Answer(String answer, boolean isAnswered) {
        this.answer = answer;
        this.isAnswered = isAnswered;
    }

    @Override
    public String toString() {
        return "Answer is " + answer;
    }
}
