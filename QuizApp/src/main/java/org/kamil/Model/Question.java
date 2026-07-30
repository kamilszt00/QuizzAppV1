package org.kamil.Model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Arrays;

public class Question {
    private String id;

    public Content content;
    public Grading_instructions grading_instructions;

    public static class Content {
        private String question_text;
        private String question_type;

        public String getQuestion_text() {
            return question_text;
        }
        public String getQuestion_type() {return question_type; }
    }


    public static class Grading_instructions {
        private String[] core_requirements;
        private String[] acceptable_variations;
        private String strictness_level;


        public String[] getCore_requirements() {return core_requirements; }
        public String[] getAcceptable_variations() {return acceptable_variations; }
        public String getStrictness_level() {return strictness_level; }
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return id + " | " + content.getQuestion_text() + " | " + content.getQuestion_type() + " | " + Arrays.toString(grading_instructions.getCore_requirements()) + " | " + Arrays.toString(grading_instructions.getAcceptable_variations()) + " | " + grading_instructions.getStrictness_level();
    }
}

