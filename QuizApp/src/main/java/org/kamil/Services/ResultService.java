package org.kamil.Services;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Model.Result;
import org.kamil.Repository.AnswerRepository;
import org.kamil.Repository.QuestionRepository;
import org.kamil.Repository.ResultRepository;

import java.util.ArrayList;
import java.util.List;

public class ResultService {
    public static List<Result> resultMapper(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < questionRepository.getQuestionsStored().size(); i++) {
            results.add(new Result(questionRepository.getQuestionsStored().get(i).content.getQuestion_text(),
                    answerRepository.getAnswers().get(questionRepository.getQuestionsStored().get(i).getId()).getAnswer(),
                    questionRepository.getQuestionsStored().get(i).getId(),
                    questionRepository.getQuestionsStored().get(i).content.getQuestion_type(),
                    questionRepository.getQuestionsStored().get(i).grading_instructions.getCore_requirements(),
                    questionRepository.getQuestionsStored().get(i).grading_instructions.getAcceptable_variations(),
                    questionRepository.getQuestionsStored().get(i).grading_instructions.getStrictness_level()));
        }
//    public Result(String question, String answer, String id, String type, String[] core_requirements, String[] acceptable_variations, String strictness_level) {



        return results;
    }
}
