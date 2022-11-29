package ru.croc.task8;

import ru.croc.task8.some_package.CountingWordsInFile;
import ru.croc.task8.some_package.IncorrectArgumentException;
import java.io.IOException;

public class Task8 {
    public static void main(String[] args) throws IncorrectArgumentException, IOException {
        if(args.length == 0){ //исключение если длина равняется 0, ведь тогда никакого пути к файлу не передано
            throw new IncorrectArgumentException("Enter the path to the file, please");
        }
        String file = args[0];
        int countOfWords = CountingWordsInFile.countingWordsInFile(file);
        System.out.println("There are " + countOfWords + " in this file");
    }
}