package ru.croc.task3.some_package;
public class ChangeMinAndMaxInArray {
    public static int findMaxIndex(int[] array){ //нахождения индекса максимального значения
        int maxNumber = array[0];
        int maxIndex = 0;
         for(int i=1;i<array.length;i++){
             if(array[i] > maxNumber){
                 maxNumber = array[i];
                 maxIndex = i;
             }
         }
         return maxIndex;
    }
    public static int findMinIndex(int[] array){ //нахождения индекса минимального значения
        int minNumber = array[0];
        int minIndex = 0;
        for(int i=1;i<array.length;i++){
            if(array[i] < minNumber){
                minNumber = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void movingElement(int indexStart , int indexFinish , int[] array){
        //тут мы перемещаем элемент с индексом indexStart на место с индексом indexFinish
        if(indexStart<=indexFinish){
            int tmp = array[indexStart];
            for(int i = indexStart ; i<indexFinish; i++){
                array[i] = array[i+1];
            }
            array[indexFinish] = tmp;
        }
        else{
            int tmp = array[indexStart];
            for(int i = indexStart ; i>indexFinish; i--){
                array[i] = array[i-1];
            }
            array[indexFinish] = tmp;
        }
    }

    public static  void changeMinElement(int[] array){ //переставляем минимальный элемент в начало
        int minIndex = findMinIndex(array);
        movingElement(minIndex, 0 , array);
    }

    public static void changeMaxElement(int[] array){ //переставляем максимальный элемент в конец
        int maxIndex = findMaxIndex(array);
        movingElement(maxIndex, array.length-1 , array);
    }

    public static void changeArray(int[] array){
        //производим последовательно перемещение максимального и минимального элементов
        //отметим что последовательность действий здесь не играет роли
        changeMaxElement(array);
        changeMinElement(array);
    }

}
