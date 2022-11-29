package ru.croc.task16;

import java.io.IOException;

public class Task16 {
    public static void main(String[] args) throws IOException {
        //String path = args[0]; // путь к директории
        String path = "C:/Users/stepa/IdeaProjects/dsStepanidenko/src/ru/croc/Task16/Новая папка";
        ru.croc.task16.mergingLogs.MergeLogs.getResult(path);
    }
}