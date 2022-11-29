package ru.croc.task3;

import java.util.Scanner;
import ru.croc.task3.some_package.ChangeMinAndMaxInArray;
public class Task3 {
    public static void main(String[] args) {

        //считывание данных
        Scanner F = new Scanner(System.in);
        System.out.println("Введите элементы массива через пробел");
        String str = F.nextLine();
        String [] numbers = str.split(" ");
        int [] numbersFinal = new int[numbers.length];
        for(int i =0 ; i<numbers.length ; i++){
            numbersFinal[i] = Integer.valueOf(numbers[i]);
        }
        //

        ChangeMinAndMaxInArray.changeArray(numbersFinal); //собственно сам процесс перемещения

        // выводим результат на экран
        for(int i = 0 ;i<numbersFinal.length;i++){
            System.out.print(numbersFinal[i] + " ");
        }

    }
}