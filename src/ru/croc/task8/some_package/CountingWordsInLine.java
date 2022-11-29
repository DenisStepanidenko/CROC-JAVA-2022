package ru.croc.task8.some_package;
import java.io.IOException;
public class CountingWordsInLine {
    public static int countingWordsInLine(String line){
        String[] helpMassive = line.trim().split("\\s+"); // разобьём строку на массив строк, где в качестве разделителя будут служить один или несколько пробелов
        return helpMassive.length;
    }

    // сделаем небольшой тест на тот текст, который дан в условии задачи

    public static void main(String[] args) throws IOException, IncorrectArgumentException {
        String s = "     ";
        String t = s.trim();
        System.out.println(t.length());

        System.out.println(CountingWordsInLine.countingWordsInLine(s));
    }


}
