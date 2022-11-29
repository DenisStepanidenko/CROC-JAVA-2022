package ru.croc.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface BlackListFilter<T> {
    // Именно тип класса-представления это и будет тип T, который мы будем фильтровать с неким предикатом
    default List<T> filterComments(Iterable<T> comments , Predicate<T> blackList){
        List<T> result = new ArrayList<>(); // результат фильтрации

        // получаем следующий элемент
        for (T element : comments) { // сначала написал через while( использовал итератор и hasNext() ) но idea заменила на более короткую версию
            if (!blackList.test(element)) {
                // метод test хранится в интерфейсе Predicate<T>, если элемент element удовлетворяет условиями, написанному
                // в предикате blackList , то выдаёт true, поэтому нам нужно использовать "!"
                result.add(element); // добавляем элемент
            }
        }
        return result;
    }
}
