package ru.croc.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Task14 {
    public static  void main(String[] args) {
        // немного тестов
        // к примеру сначала затестим на числах
        List<Integer> test1 = new ArrayList<>(List.of(1,2,3,4,5,6));
        BlackListFilter <Integer> test2 = new BlackListFilter<Integer>() {
            @Override
            public List<Integer> filterComments(Iterable<Integer> comments, Predicate<Integer> blackList) {
                return BlackListFilter.super.filterComments(comments, blackList);
            }
        };
        Predicate<Integer> pr1 = x -> x >= 5; //больше или равны 5 убираем
        List<Integer> result = test2.filterComments(test1 , pr1);
        System.out.println(result);



        //проверим со строками
        List<String> test3 = new ArrayList<>(List.of("Anna" , "hello" , "why"));
        BlackListFilter <String> test4 = new BlackListFilter<String>() {
            @Override
            public List<String> filterComments(Iterable<String> comments, Predicate<String> blackList) {
                return BlackListFilter.super.filterComments(comments, blackList);
            }
        };
        Predicate<String> pr2 = x -> x.startsWith("A"); // всё что начинается с буквы A
        List<String> test5 = test4.filterComments(test3 , pr2);
        System.out.println(test5);
    }
}