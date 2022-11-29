package ru.croc.task2.some_package;
import java.util.Scanner;
public class WorkingWithBytes{
    public static double loadingAndCheck(Scanner F){ // метод для считывания данных
        System.out.println("Введите число байт");
        double numbersOfByte = F.nextDouble();
        if(WorkingWithBytes.checkForNegativity(numbersOfByte)){
            while(WorkingWithBytes.checkForNegativity(numbersOfByte)){
                System.out.println("Вы ввели некорректное число байт, повторите попытку: ");
                numbersOfByte = WorkingWithBytes.loadingAndCheck(F);
            }

        }
        return numbersOfByte;

    }
    public static boolean checkForNegativity( double x){ // метод для проверки на отрицательность
        if(x<0){
            return true;
        }
        else{
            return false;
        }
    }
}
