package ru.croc.task2;
import ru.croc.task2.some_package.WorkingWithBytes;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner F = new Scanner(System.in);
        double  numbersOfByte;
        numbersOfByte = WorkingWithBytes.loadingAndCheck(F);
        String[] unitsOfMeasurement = {"B" , "KB" , "MB" , "GB" , "TB"};
        int i = 0;
        while(numbersOfByte>=1024){
            if(i == (unitsOfMeasurement.length-1)){
                break;
            }
            numbersOfByte/=1024;
            i++;

        }
        System.out.println((String.format("%.1f",numbersOfByte)) + " " + unitsOfMeasurement[i]);

    }
}