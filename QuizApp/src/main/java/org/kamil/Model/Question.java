package org.kamil.Model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Question {
    private String answer;

    public Content content;


    public static class Content {
        public String question_text;
        public String question_type;

        public String getQuestion_text() {
            return question_text;
        }
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
