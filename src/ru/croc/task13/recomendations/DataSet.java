package ru.croc.task13.recomendations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class DataSet {
    private Map<Integer, String> films;
    private Map<Integer, ArrayList<Integer>> views;

    public DataSet(String pathToTheFilm, String pathToTheViews) throws IOException {
        films = Parser.parseFilms(pathToTheFilm);
        views = Parser.parseViews(pathToTheViews);
    }

    public Map<Integer, String> getFilms() {
        return films;
    }

    public Map<Integer, ArrayList<Integer>> getViews() {
        return views;
    }
}
