package org.kamil.Config;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ConfigService {

    private static final String CHAPTERS_PATH_KEY = "ChaptersQuizPath";
    private static final String RESULT_SAVE_KEY = "ResultsSavePath";
    private Preferences prefs = Preferences.userRoot().node(ConfigService.class.getName());


    public void SetChaptersPath(String path) {
        prefs.put(CHAPTERS_PATH_KEY, path);
    }

    public String getChaptersPath() {
        return prefs.get(CHAPTERS_PATH_KEY,"");
    }

    public boolean hasChaptersPath(){
        return !getChaptersPath().isEmpty();
    }

    public void SetResultSavePath(String path) {
        prefs.put(RESULT_SAVE_KEY, path);
    }

    public String getResultSavePath() {
        return prefs.get(RESULT_SAVE_KEY,"");
    }

    public boolean hasResultSavePath(){
        return !getResultSavePath().isEmpty();
    }















}
