package ru.croc.task13.recomendations;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FindingRecommendations {
    private DataSet data;

    public FindingRecommendations(String pathToTheFilms, String pathToTheViews) throws IOException {
        this.data = new DataSet(pathToTheFilms, pathToTheViews);
    }

    // данный метод возвращает нам самый популярный фильм среди рекомендованных пользователю
    public String getPopularFilmForUser(String filmsOfUser) {
        Set<Integer> allRecommendationForUser = getAllRecommendations(filmsOfUser);
        int maxIndex = 0;
        Integer recommendationFilm = null;
        for (Integer candidates : allRecommendationForUser) {
            int count = 0;
            for (Map.Entry<Integer, ArrayList<Integer>> entry : data.getViews().entrySet()) {
                for (Integer films : entry.getValue()) {
                    if (Objects.equals(films, candidates)) {
                        count++;
                    }
                }
            }
            if (count > maxIndex) {
                maxIndex = count;
                recommendationFilm = candidates;
            }
        }
        if (recommendationFilm != null) {
            return data.getFilms().get(recommendationFilm); // возвращаем тот фильм, который имеет больше всего просмотров среди остальных пользователей
        } else {
            return "Not recommendation";
        }
    }

    /*
    данный метод который вернёт нам список просмотров только тех юзеров,
    которые посмотрели хотя бы половину фильмов пользователя,
    а также удалит из него те, которые пользователь смотрел
    */
    private Set<Integer> getAllRecommendations(String filmsOfUser) {
        // Заметим, что нам нужен именно уникальный лист просмотров пользователя для которого мы ищем рекомендацию
        Set<Integer> uniqueUserViews = Arrays.stream(filmsOfUser.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        // данную переменную мы вернём в качестве результата
        // она будет содержать в себе кандидатов на рекомендацию пользователю
        Set<Integer> allRecommendationForUser = new HashSet<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : data.getViews().entrySet()) {
            // Заметим,что для отбора нам нужно для каждого пользователя уникальный набор просмотров
            Set<Integer> viewsOfCurrentUser = new HashSet<>(entry.getValue());
            Set<Integer> viewsOfMainUser = new HashSet<>(uniqueUserViews);
            // требуется создания копии Set uniqueUserViews ,так как далее будем его менять( метод retainAll) и сранивать размер
            // MainUser - тот пользователь, для которого ищем рекомендацию
            viewsOfMainUser.retainAll(viewsOfCurrentUser);
            // тут мы сравниваем фильмы, просмотренные пользователем с теми фильмами, которые у нас хранятся в viewsOfCurrentUser
            // то есть если какой-то элемент из uniqueUserViews удалится, это будет означать что в viewsOfCurrentUser такого элемента не было
            if (viewsOfMainUser.size() >= Math.round(uniqueUserViews.size() / 2.0)) {
                viewsOfCurrentUser.removeAll(uniqueUserViews); // оставляем только те фильмы, которые не смотрел пользователь
                allRecommendationForUser.addAll(viewsOfCurrentUser);
            }
        }
        return allRecommendationForUser;
    }
}
