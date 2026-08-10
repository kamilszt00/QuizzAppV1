package org.kamil.Services;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Model.Result;
import org.kamil.Repository.RepositoryMap;


import java.util.Map;


public class ResultService {
    public static void resultMapper(RepositoryMap<String,Question> questionRepo, RepositoryMap<String,Answer> answerRepo, RepositoryMap<String,Result> resultRepo) {
            questionRepo.forEach((k,q) -> {
                resultRepo.addToMap(k,new Result(q,answerRepo.getValue(k).getAnswer()));
            });



    }
}
