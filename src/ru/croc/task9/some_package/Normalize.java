package ru.croc.task9.some_package;
public class Normalize {
    public static String normalizePathFile(String file){
        String[] fileNew = file.trim().split("/");
        // идея решения
        // Все вхождения "." являются избыточными
        // если перед “..” предшествует имя, отличное от “..”, тогда ".."  и имя считаются избыточными

        for(int i = 0; i < fileNew.length; i++){
            if(fileNew[i].equals(".")){
                fileNew[i] = null;
                continue;
            }
            if(fileNew[i].equals("..")){ // можно было подумать, что нужно смотреть на (i-1) элемент, но он мог быть null на предыдущих этапах, поэтому используем цикл для поиска
                for(int j = i-1; j >=0 ; j--){
                    if( fileNew[j] != null ){
                        if( !(fileNew[j].equals("..")) ) {
                            fileNew[j] = null;
                            fileNew[i] = null;
                            break;
                        }
                    }
                }
            }
        }
        String answer = ""; // в эту переменную запишем нормализованный путь
        for(int i = 0 ; i < fileNew.length ; i++){
            if(fileNew[i] == null){
                continue;
            }
            else{
                if(i == fileNew.length-1){
                    answer += fileNew[i];
                }
                else{
                    answer += fileNew[i] + "/";
                }
            }
        }
        return answer;
    }
}
