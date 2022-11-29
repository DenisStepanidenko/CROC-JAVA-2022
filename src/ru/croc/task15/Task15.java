package ru.croc.task15;

import java.io.IOException;
import ru.croc.task15.TimeCounting.TimeCounting;
public class Task15 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/stepa/IdeaProjects/Task15/src/Текстовый документ.txt"; //создаём путь к файлу, я тестил файл, который в условии задачи и ещё немного его изменял
        TimeCounting.getResult(filePath); //собственно самая функция, которая выводит результат
        // данная функция работает так, что не важно в каком порядке вообще идут отделы в файле
    }
}