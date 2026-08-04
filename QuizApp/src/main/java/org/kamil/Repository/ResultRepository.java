package org.kamil.Repository;

import org.kamil.Model.Question;
import org.kamil.Model.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {

    private List<Result> resultsStored = new ArrayList<>();


    public List<Result> getResultsStored() {
        return resultsStored;
    }

    public void setResultsStored(List<Result> resultsStored) {
        this.resultsStored = resultsStored;
    }

    public void addResult(Result r) {
        resultsStored.add(r);
    }




}
