package ru.croc.task17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parser {
    // данный метод записывает парсит все заказы
    public static List<Order> parseOrders(String path) {
        List<Order> result = new ArrayList<>();
        Path pathToTheFile = Paths.get(path);
        try {
            List<String> allLinesInFile = Files.readAllLines(pathToTheFile);
            for (String s : allLinesInFile) {
                String[] currentLine = s.split(",");
                result.add(new Order(Integer.parseInt(currentLine[0]), currentLine[1], currentLine[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // данный метод парсит все товары
    public static List<Product> parseProducts(String path) {
        List<Product> result = new ArrayList<>();
        Path pathToTheFile = Paths.get(path);
        Set<String> articles = new HashSet<>(); // нужен для соблюдения уникальности( по условию товары с одинаковым артиклом  - "равны" )
        try {
            List<String> allLinesInFile = Files.readAllLines(pathToTheFile);
            for (String s : allLinesInFile) {
                String[] currentLine = s.split(",");
                if(articles.add(currentLine[2])){
                    result.add(new Product(currentLine[2] , currentLine[3] , Integer.parseInt(currentLine[4])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
