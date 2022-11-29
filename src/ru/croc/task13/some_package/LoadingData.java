package ru.croc.task13.some_package;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LoadingData {
    private static Path pathListOfFilms;
    private static Path pathViewingHistory;
    public static void initialFiles(String path1 , String path2 , HashMap<Integer,String> listOfFilms , ArrayList<Set<Integer>> viewingHistory , ArrayList<ArrayList<Integer>> generalСountingFilms) throws IOException {
        pathListOfFilms = Paths.get(path1);
        pathViewingHistory = Paths.get(path2);
        // далее разобьём инициализацию на два метода, чтобы было красивее :)
        initialFilms(pathListOfFilms , listOfFilms); //заполняем данными список всех фильмов
        initialViews(pathViewingHistory , viewingHistory , generalСountingFilms); //заполняем данными список всех просмотров

    }

    private static void initialFilms(Path path, HashMap<Integer, String> listOfFilms) throws IOException { // инициализируем список всех фильмов
        try{
            List<String> helpListFilms = Files.readAllLines(pathListOfFilms);
            for(String s : helpListFilms){
                String[] helpMassive = s.split(",");// вспомогающий массив, для каждой строки создадим массив с номером и название фильма
                Integer number = Integer.valueOf(helpMassive[0]);
                String name = helpMassive[1];
                listOfFilms.put(number , name); // добавили новый список в нашу мапу
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initialViews(Path path, ArrayList<Set<Integer>> viewingHistory ,ArrayList<ArrayList<Integer>> generalСountingFilms ) { // инициализация списка всех просмотров
        try{
            List<String> helpListViews = Files.readAllLines(pathViewingHistory); //вспомогающий List
            ArrayList<Integer> helpArray = new ArrayList<>(); // вспомогающий Array
            for(String s : helpListViews){
                String[] helpMassive = s.split(",");
                Set<Integer> helpSet = new HashSet<>(); //вспомогающий Set
                for(String m : helpMassive){
                    helpSet.add(Integer.valueOf(m));
                    helpArray.add(Integer.valueOf(m));
                }
                generalСountingFilms.add(helpArray);
                viewingHistory.add(helpSet);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
