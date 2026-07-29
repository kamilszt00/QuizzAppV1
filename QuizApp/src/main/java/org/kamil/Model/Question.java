package org.kamil.Model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Question {
    private String id;

    public Content content;


    public static class Content {
        private String question_text;
        private String question_type;

        public String getQuestion_text() {
            return question_text;
        }
        public String getQuestion_type() {return question_type; }
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

