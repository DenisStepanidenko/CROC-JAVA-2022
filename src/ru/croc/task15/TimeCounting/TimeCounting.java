package ru.croc.task15.TimeCounting;

import java.io.IOException;
import java.util.*;

public class TimeCounting {
    private static ArrayList<Organization> Data = new ArrayList<>();
    // в листе data будем хранить организации( в объекте организации есть время работы и array list дочерних организаций )
    // но подробнее можно посмотреть в структуре класса organization
    public static void getResult(String filePath) throws IOException {
        LoadingData.loadingData(filePath , Data); // загрузили для начали все отделы
        for(Organization s : Data){
            if(s.nameOfParent.equals("-")){
                System.out.println(s.totalProcessTime()); // начиная с корневого отдела введём подсчёт времени
                break;
            }
        }
    }
}
