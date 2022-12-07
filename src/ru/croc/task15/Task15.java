package ru.croc.task15;

import ru.croc.task15.timeCounting.ParseAndSearchingRoot;

import java.io.IOException;

public class Task15 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/stepa/IdeaProjects/Croc/src/ru/croc/task15/Текстовый документ.txt";
        int answer = ParseAndSearchingRoot.parseAndSearchingRoot(filePath).totalProcessTime();
        System.out.println(answer);
        
    }
}