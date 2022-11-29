package ru.croc.task12.checkingSpam;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FilterWords implements BlackListFilter{
    public void filterComments(List<String> comments, Set<String> blackList){
        Iterator<String> iter = comments.iterator(); // получаем итератор из коллекции
        while(iter.hasNext()){ // данный метод проверяет есть ли хотя бы один элемент для прочтения
            String words = iter.next(); // получаем очередной элемент
            for(String badWords : blackList){
                if(words.toLowerCase().contains(badWords.toLowerCase())){ // проверка есть ли в строке words подстрока badWords
                    // так как из-за регистра у нас может не найтись плохих слов, то сделаем строку words
                    // полностью всю в нижнем регистре. Также по условию не понятно в каком регистре слова в blackList, то сделаем их тоже в нижнем регистре
                    iter.remove();
                }
            }
        }
    }
}
