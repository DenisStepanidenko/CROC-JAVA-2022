package ru.croc.task10.some_package;
//import java.util.Arrays;
public class Solution {
    public static volatile String password;
    public static String calculatePassword(int numberOfThreads , String hashPassword)
    {
        password = "";

        Thread[] threads = new Thread[numberOfThreads];
        for(int i = 1 ; i<=numberOfThreads; i++){
            threads[i-1] = new Thread( new FindingPassword(7 , i, numberOfThreads , hashPassword));
            threads[i-1].start();
        }
        try{
            for(int i = 0 ; i < numberOfThreads; i++){
                threads[i].join();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        // join() использовали для того , чтобы перейти на эту строчку только после того, как все потоки закончили свою работу
        return password;
    }

}