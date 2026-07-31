package org.kamil.Repository;

import org.kamil.Model.Question;
import org.kamil.Model.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {

    private List<Result> resultsStored;


    public List<Result> getResultsStored() {
        return resultsStored;
    }

    public void setResultsStored(List<Result> resultsStored) {
        this.resultsStored = resultsStored;
    }

    public ResultRepository(List<Result> results) {
        resultsStored = results;
    }





}
