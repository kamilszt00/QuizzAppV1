package org.kamil.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class RepositoryMap<T,E> {

    private Map<T,E> mapOfStored = new LinkedHashMap<>();



    public void setMapOfStored(Map<T, E> mapOfStored) {
        this.mapOfStored = mapOfStored;
    }

    public void addToMap(T key, E value) {
        if (mapOfStored.containsKey(key)) {
            throw new IllegalArgumentException("Duplicate key: " + key);
        }
        mapOfStored.put(key,value);
    }

    public int size() {
        return mapOfStored.size();
    }

    public void forEach(BiConsumer<T,E> action) {
        mapOfStored.forEach(action);
    }

    public E getValue(T key) {
        return mapOfStored.get(key);
    }


}
