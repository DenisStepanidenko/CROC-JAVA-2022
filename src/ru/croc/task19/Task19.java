package ru.croc.task19;

import java.io.FileWriter;
import java.io.IOException;

public class Task19 {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("C:/Users/stepa/IdeaProjects/Croc/src/ru/croc/task19/strange_task.txt", false))
        {
            String text = "Hello, world!";
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
