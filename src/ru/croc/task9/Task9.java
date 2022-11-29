package ru.croc.task9;

import ru.croc.task9.some_package.Normalize;
public class Task9 {
    public static void main(String[] args) {
        String s = "КРОК/работа/src/./../../универ/../../../мемы/котики";
        System.out.println("Normalized path - " + Normalize.normalizePathFile(s));
    }
}