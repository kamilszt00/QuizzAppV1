package org.kamil.Model;

public class Result {
    private String question;
    private String answer;
    private String id;
    private String type;
    private String[] core_requirements;
    private String[] acceptable_variations;
    private String strictness_level;

    public Result(String question, String answer, String id, String type, String[] core_requirements, String[] acceptable_variations, String strictness_level) {
        this.answer = answer;
        this.question = question;
        this.id =  id;
        this.type = type;
        this.core_requirements = core_requirements;
        this.acceptable_variations = acceptable_variations;
        this.strictness_level = strictness_level;
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

    public String getStrictness_level() {
        return strictness_level;
    }

    public String[] getCore_requirements() {
        return core_requirements;
    }

    public String[] getAcceptable_variations() {
        return acceptable_variations;
    }
}
