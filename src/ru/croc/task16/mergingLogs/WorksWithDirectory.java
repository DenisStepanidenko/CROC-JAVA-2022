package ru.croc.task16.mergingLogs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static java.nio.file.Files.isRegularFile;

public class WorksWithDirectory {
    //опишем метод, который возвратит все файлы в директориях и дочерних директориях
    public static List<Path> getAllFilesLog(Path file) throws IOException {
        List<Path> helpList = new ArrayList<>();
        // конструкция для обработки всех файлов( именно тех которые нам подходят, а то есть логов) в файловом дереве
        try (Stream<Path> current = Files.walk(file)) {
            helpList = current.filter(Files::isRegularFile).filter(WorksWithDirectory::checkingFileForLog).collect(Collectors.toList());
            // сначала написал через лямбды, но idea предложила заменить всё ссылкой на методы
        }
        return helpList;
    }

    // Чтобы далее просто было считать данные из файла, то сохраним для каждого файла BufferedReader
    public static List<BufferedReader> getAllReader(Path file) throws IOException {
        ArrayList<BufferedReader> result = new ArrayList<>();
        for (Path x : getAllFilesLog(file)) {
            result.add(new BufferedReader(new FileReader(x.toString())));
        }
        return result;
    }

    private static boolean checkingFileForLog(Path file) {
        String nameOfFile = file.getFileName().toString(); // получаем имя файла по его пути
        int helpNumber = nameOfFile.lastIndexOf(".");
        if (helpNumber == -1) {
            return false;
        } else {
            return (nameOfFile.substring(helpNumber).toLowerCase().equals(".log") || nameOfFile.substring(helpNumber).toLowerCase().equals(".trace"));
            // тут мы возвращаем true если нашли нужное нам расширение файла
        }
    }
}
