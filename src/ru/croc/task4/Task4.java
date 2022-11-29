package ru.croc.task4;

import java.util.Scanner;
import ru.croc.task4.some_package.WorkWithComments;
public class Task4 {
    public static void main(String[] args) {
        //изначальная строка, которую нужно обрабатывать
        String source = """        
                /*
                 * My first ever program in Java!
                 */
                class Hello { // class body starts here\s
                 \s
                  /* //main method */
                  public static void main(String[] args/* we put command line arguments here*/) {
                    // this line prints my first greeting to the screen
                    System.out.println("Hi!"); // :)
                  }
                } // the end
                // to be continued...
                                
                """;


        String noComments = WorkWithComments.removeJavaComments(source); // собственно сам процесс

        System.out.println(noComments); //вывод уже обработанной строки

    }
}