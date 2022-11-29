package ru.croc.task16.mergingLogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MergeLogs {
    private static List<BufferedReader> allReader;
    private static List<String> currentMinimums; // лист текущих минимумов( будет объяснено в идеи алгоритма)

    public static void getResult(String file) throws IOException {
        Path pathFile = Paths.get(file);
        firstIteration(pathFile);
    }

    // идея алгоритма состоит в том, что мы как бы "построчно" сравниваем минимумы
    // Кстати такая реализация возможна лишь из-за того, что строки в логах отсортированы по возрастанию
    // то есть к примеру мы берём первую строчку во всех файлах - ищем минимум , его выводим, и в данном файле читаем следующую строку
    // Следующий метод по факту делает первую итерацию( а вместе с ней и последующие )
    private static void firstIteration(Path pathFile) throws IOException {
        allReader = WorksWithDirectory.getAllReader(pathFile);
        currentMinimums = new ArrayList<>();
        for (BufferedReader x : allReader) {
            String line = x.readLine();
            if (line == null) {
                allReader.remove(x);
            } else {
                currentMinimums.add(line);
            }
        }
        afterTheFirstIteration();
    }

    private static void afterTheFirstIteration() throws IOException {
        while (!allReader.isEmpty()) {
            long min = Long.MAX_VALUE; // это сделано для того, что if под номером 1 сработал и выдал нам реально существующий у нас минимум
            int minIndex = 0;
            for (int i = 0; i < currentMinimums.size(); i++) { // if номер 1
                long time = Long.parseLong(currentMinimums.get(i).substring(0, currentMinimums.get(i).indexOf(' ')));
                if (time < min) {
                    min = time;
                    minIndex = i;
                }
            }

            System.out.println(currentMinimums.get(minIndex));
            String nextLine = allReader.get(minIndex).readLine(); // читаем следующую строку в файле где нашли минимум
            if (nextLine == null) {
                allReader.remove(allReader.get(minIndex));
                currentMinimums.remove(currentMinimums.get(minIndex));
            } else {
                currentMinimums.set(minIndex, nextLine);
            }
        }
    }
}
