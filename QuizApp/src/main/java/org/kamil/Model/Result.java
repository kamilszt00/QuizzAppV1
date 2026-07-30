package org.kamil.Model;

public class Result {
    private String question;
    private String answer;
    private String id;
    private String type;
    private String requirements;
    private String variations;
    private String level;

    public Result(String question, String answer, String id, String type, String requirements, String variations, String level) {
        this.answer = answer;
        this.question = question;
        this.id =  id;
        this.type = type;
        this.requirements = requirements;
        this.variations = variations;
        this.level = level;
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

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getVariations() {
        return variations;
    }
}
