package ru.croc.task12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ru.croc.task12.checkingSpam.FilterWords;
public class Task12{
    public static void main(String[] args) {

        // немного тестов
        List<String> commments = new ArrayList<>();
        commments.add("I like to speak English fluently and correctly");
        commments.add("This exam seems very difficult");
        commments.add("This result doesn't depend on you");
        Set<String> blackList = new HashSet<>();
        //blackList.add("seEms");
        blackList.add("fluently");
        FilterWords test = new FilterWords();
        test.filterComments(commments , blackList);

        System.out.println(commments);


    }
}