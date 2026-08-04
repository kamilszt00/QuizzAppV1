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
    public static void resultMapper(QuestionRepository questionRepository, AnswerRepository answerRepository, ResultRepository resultRepository) {
            questionRepository.getQuestionsStored().forEach(question -> {
                resultRepository.addResult(new Result(answerRepository.getAnswers().get(question.getId()).getAnswer(), question));
            });



    }
}
