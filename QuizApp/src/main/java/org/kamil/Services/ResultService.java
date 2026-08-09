package org.kamil.Services;

import org.kamil.Model.Answer;
import org.kamil.Model.Question;
import org.kamil.Model.Result;



import java.util.Map;


public class ResultService {
    public static void resultMapper(Map<String,Question> questionMap,Map<String, Answer> answerMap, Map<String,Result> resultMap) {
            questionMap.forEach((k,q) -> {
                resultMap.put(k,new Result(q,answerMap.get(k).getAnswer()));
            });



    }
}
