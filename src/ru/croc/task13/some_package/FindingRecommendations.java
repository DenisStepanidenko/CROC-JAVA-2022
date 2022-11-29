package ru.croc.task13.some_package;

import java.io.IOException;
import java.util.*;

//import java.util.Pa
public class FindingRecommendations {
    private static final String listAvailableMovies = "C:/Users/stepa/IdeaProjects/Task13/src/films.txt"; // инициализируем путь с списку всех фильмов
    private static final String movieViewingHistory = "C:/Users/stepa/IdeaProjects/Task13/src/history.txt"; // инициализируем путь к истории просмотра фильмов
    private static HashMap<Integer , String> listOfFilms = new HashMap<>(); // будет хранить мапу (идентификатор , название фильма)
    private static  ArrayList<Set<Integer>> viewingHistory = new ArrayList<>(); // будет хранить только уникальные просмоты, это нужно для первого пункта
    private static ArrayList<ArrayList<Integer>> generalСountingFilms = new ArrayList<>(); // будет хранить всевозможные просмотры фильмов каждого конкртеного пользователя
    private static Set<Integer> recommendedForViewing; // будет хранить список тех фильмов, которые являются кандидатами к просмотру
    private static Set<Integer> viewsFilmsUser = new HashSet<>(); // Те фильмы которые посмотрел пользователь


    public static String FindRecommendations(String viewsFilms) throws IOException {
        //для начала загрузим данные в  listOfFilms и viewingHistory
        // чтобы было красивее, то создадим отдельный класс для этого
        LoadingData.initialFiles(listAvailableMovies , movieViewingHistory , listOfFilms , viewingHistory , generalСountingFilms);
        // далее создадим Set тех фильмов, которые смотрел пользователь

        String[] helpMassive = viewsFilms.split(",");
        for(String s : helpMassive){
            viewsFilmsUser.add(Integer.valueOf(s));
        }

        // далее создадим Set который будет показывать всех кандидатов к просмотру
        recommendedForViewing = checkForTheCondition(viewsFilmsUser);

        return finalRecommendation(recommendedForViewing);

    }
    private static String finalRecommendation(Set<Integer> recommendedForViewing){
        int maxIndex = 0; // изначально зададим нулём, если больше не найдётся, то просто выведем самый первый фильм
        Integer recommendationFilm = null;
        for(Integer recommended : recommendedForViewing){
            int count = 0;
            for(ArrayList<Integer> views : generalСountingFilms){
                for(Integer films : views){
                    if(Objects.equals(films, recommended)){
                        count++;
                    }
                }
            }
            if(count > maxIndex){
                maxIndex = count;
                recommendationFilm = recommended;
            }
        }
        if(recommendationFilm != null){
            return listOfFilms.get(recommendationFilm); // возвращаем тот фильм, который имеет больше всего просмотров
        }
        else{
            return "Not recommendation(";
        }
    }

    private static Set<Integer> checkForTheCondition(Set<Integer> filmsOfUser){
        // метод который вернёт нам список просмотров только тех юзеров, которые посмотрели хотя бы половину фильмов пользователя, а также удалит из него те, которые пользователь смотрел
        Set<Integer> recommendation = new HashSet<>();
        for(Set<Integer> views : viewingHistory){
            Set<Integer> helpSet = new HashSet<>(filmsOfUser); //добавляем в вспомогательный Set все просмотренные фильмы пользователем
            helpSet.retainAll(views); // тут мы сравниваем фильмы, просмотренные пользователем с теми фильмами, которые у нас хранятся в views
            // то есть если какой-то элемент из helpSet удалится, это будет означать что в views такого элемента не было
            if(helpSet.size() >= Math.round(filmsOfUser.size() / 2.0)){
                Set<Integer> helpSet2 = new HashSet<>(views); // вспомогательный Set
                helpSet2.removeAll(filmsOfUser); // оставляем только те, которые не смотрел пользователь
                recommendation.addAll(helpSet2); // добавляем все элементы из helpSet2 в recommendation
            }

        }
        return recommendation;
    }

}
