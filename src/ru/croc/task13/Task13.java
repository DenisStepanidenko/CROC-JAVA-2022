package ru.croc.task13;

import ru.croc.task13.some_package.FindingRecommendations;
import java.io.IOException;
import java.util.Scanner;
public class Task13 {
    public static void main(String[] args) throws IOException {
        Scanner F = new Scanner(System.in);
        System.out.println("Введите пожалуйста список просмотров по которому хотите получить рекомендацию. Вводите с разделением запятой и без пробелов");
        String films = F.next();
        String answer = FindingRecommendations.FindRecommendations(films);
        System.out.println(answer);
        // на тестах который дан в условии задачи был выдан верный ответ, ура!!
    }
}