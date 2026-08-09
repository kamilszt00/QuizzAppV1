package org.kamil.Repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> ListOfStored =  new ArrayList<>();



    public List<T> getListOfStored() {
        return ListOfStored;
    }

    public void setListOfStored(List<T> listOfStored) {
        ListOfStored = listOfStored;
    }

    public void addToStore(T r) {
        ListOfStored.add(r);
    }
}
