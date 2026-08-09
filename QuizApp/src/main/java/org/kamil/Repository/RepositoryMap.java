package org.kamil.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepositoryMap<T,E> {

    private Map<T,E> MapOfStored = new LinkedHashMap<>();


    public Map<T, E> getMapOfStored() {
        return MapOfStored;
    }

    public void setMapOfStored(Map<T, E> mapOfStored) {
        MapOfStored = mapOfStored;
    }

    public void mapToStored(T key,E value) {
        MapOfStored.put(key,value);
    }
}
