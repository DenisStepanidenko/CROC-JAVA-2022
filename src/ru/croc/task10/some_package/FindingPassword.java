package ru.croc.task10.some_package;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class FindingPassword implements Runnable  {

    private String hashPassword;
    private final int ALPHABET = 26; // мощность алфавита( все строчные латинские буквы) , нужен нам для подсчёта всевозможного количество комбинаций слов
    private final int LENGTH_PASSWORD; //длина пароля, который мы ищем
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private int threadNumber; // номера конкретного потока

    private final long POSSIBLE_NUMBER_OF_WORDS; // сколько всего паролей можно составить длины LENGTH_PASSWORD с мощностью алфавита ALPHABET
    private final int NUMBER_OF_THREADS; // сколько всего потоков
    private long start; // начало для конкретного потока
    private long finish; // конец для конкретного потока

    //по поводу код стайла
    // "идея" подсвечивает переменные threadNumber , POSSIBLE_NUMBER_OF_WORDS , NUMBER_OF_THREADS и предлагает их инициализировать в конструкторе
    // я этого не делаю , так как тогда ухудшится читаемость кода и структура класса
    // "идея" подсвечивает переменные start , finish , threadNumber и предлагает сделать их final
    // но это неверно, так как для каждого потока своё начало и конец,а также номера потоков разные

    private static volatile boolean checkingForFinding;

    //констурктор с вычислениями переменных start , finish , POSSIBLE_NUMBER_OF_WORDS
    public FindingPassword(int lengthPassword , int threadNumber , int numberOfThreads , String hashPassword){
        checkingForFinding = false;
        this.hashPassword = hashPassword;
        this.LENGTH_PASSWORD = lengthPassword;
        this.threadNumber = threadNumber;
        this.NUMBER_OF_THREADS = numberOfThreads;
        POSSIBLE_NUMBER_OF_WORDS = (long) Math.pow(ALPHABET , LENGTH_PASSWORD); //вычисляем всевозможные варианты слов
        //теперь нужно задать начало и конец для конкретного потока
        //общая идея это будет формирования слов на основе  ASCII таблицы
        //для себя будем считать, что нулевое слово(почему именно так будет видно в методе createWords) - "aaaaaaa"
        //поэтому для первого потока начало должно быть в нуле, это можно сделать внедрив множитель (threadNumber - 1)
        start = (POSSIBLE_NUMBER_OF_WORDS * ( threadNumber - 1)) / NUMBER_OF_THREADS;

        // finish подбираем так, чтобы для следующего потока ( finish + 1 ) было стартом
        // конечно тут будут получаться в правой части нецелые числа, но так как слева стоит тип long, то все знаки после запятой просто отбросятся
        finish = ( (POSSIBLE_NUMBER_OF_WORDS * threadNumber) / NUMBER_OF_THREADS ) - 1;
    }

    // Данный метод ищет совпадение заданного хеша с хешем всевозможных слов
    @Override
    public void run(){
        for(long i = start ; i <= finish && !checkingForFinding ; i++){
            String password = createWords(i);
            if(hashPassword(password).equals(hashPassword)){
                Solution.password = password;
                checkingForFinding = true;
            }
        }
    }

    // данный метод выдаёт слово в соответствии с номером n
    private String createWords(long n){
        int[] helpMassive = new int[LENGTH_PASSWORD];
        for(int i = 0 ; i < LENGTH_PASSWORD; i++){
            helpMassive[i] = (int) (n % ALPHABET);
            n = n / ALPHABET;
            // общая идея данного алгоритма такова, что на каждом этапе у нас будут фиксированные буквы, а все остальные будут перебираться
            //то есть:
            // aaaaaaa , baaaaaa , caaaaaa , ..... , zaaaaaa ( тут мы фиксируем вторую букву a )
            // abaaaaa , bbaaaaa , cbaaaaa , ..... ,  zbaaaaa ( тут мы фиксируем вторую букву b )
            // и так далее...
        }
        StringBuilder password = new StringBuilder("");
        for(int i = 0 ; i < LENGTH_PASSWORD; i++){
            password.append((char) ('a' + helpMassive[i]) ); // тут как раз видно, что при входном параметре n=0 , словом будет aaaaaaa, поэтому и сделали именно такое слово - нулевым
        }
        return password.toString();
    }



    //генерация кэша
    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    //генерация кэша
    public static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }
}
