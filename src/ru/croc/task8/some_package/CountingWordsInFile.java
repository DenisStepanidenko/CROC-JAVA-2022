package ru.croc.task8.some_package;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CountingWordsInFile {
    public static int countingWordsInFile(String file) throws IOException , IncorrectArgumentException{
        int numberOfWords = 0;
        try(BufferedReader in = new BufferedReader(new FileReader(file))){
            String line = null; // идея в том, чтобы разбить файл на строки, и считать количество слов в каждой строке
            while((line = in.readLine()) != null){
                if(line.trim().isEmpty()){
                    continue;
                }
                else {
                    numberOfWords += CountingWordsInLine.countingWordsInLine(line);
                }
            }

        }catch (FileNotFoundException e){ //исключение, если файл не найден
            throw new IncorrectArgumentException("The file at this address was not found");
        }
        return numberOfWords;
    }
}
