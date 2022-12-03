package ru.croc.task13;

import ru.croc.task13.some_package.FindingRecommendations;
import java.io.IOException;
import java.util.Scanner;
public class Task13 {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        System.out.println("Введите пожалуйста список просмотров по которому хотите получить рекомендацию. Вводите с разделением запятой и без пробелов");
        String filmsOfUser = f.next();
        String pathToTheFilms = "C:/Users/stepa/IdeaProjects/Croc/src/ru/croc/task13/films.txt";
        String pathToTheViews = "C:/Users/stepa/IdeaProjects/Croc/src/ru/croc/task13/history.txt";
        FindingRecommendations test = new FindingRecommendations(pathToTheFilms , pathToTheViews);
        System.out.println(test.getPopularFilmForUser(filmsOfUser));

    }
}