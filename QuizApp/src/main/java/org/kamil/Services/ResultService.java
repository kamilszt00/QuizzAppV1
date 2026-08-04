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
        questionRepository.getQuestionsStored().forEach(question -> {
            results.add(new Result(answerRepository.getAnswers().get(question.getId()).getAnswer() , question));
        });




        return results;
    }
}
