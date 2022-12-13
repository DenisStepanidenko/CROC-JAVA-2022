package ru.croc.task19;

import java.io.FileWriter;
import java.io.IOException;

public class Task19 {
    public static void main(String[] args) throws IOException {
        try(FileWriter writer = new FileWriter("C:/Users/stepa/IdeaProjects/Croc/src/ru/croc/tas9/strange_task.txt", false))
        {
            String text = "Hello, world!";
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            throw  ex;
            
        }
        System.out.println("hello");
    }
}
