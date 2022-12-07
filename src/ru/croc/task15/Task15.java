package ru.croc.task15;

import ru.croc.task15.timeCounting.ParseAndSearchingRoot;

import java.io.IOException;

public class Task15 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/stepa/IdeaProjects/Croc/src/ru/croc/task15/Текстовый документ.txt"; //создаём путь к файлу, я тестил файл, который в условии задачи и ещё немного его изменял
        int answer = ParseAndSearchingRoot.parseAndSearchingRoot(filePath).totalProcessTime();
        System.out.println(answer);
        // данная функция работает так, что не важно в каком порядке вообще идут отделы в файле
    }
}