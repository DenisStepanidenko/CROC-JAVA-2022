package ru.croc.task11.some_package;
import java.time.LocalDateTime;


public class Lot{
    private volatile long costOfLot; // наибольшая текущая стоимость лота преложенная пользователем currentName, сделал long так как в теории ставка может быть огромной, если товар уникальный
    private volatile String currentName; // текущее имя человека, сделавшего наибольшую ставку costOfLot
    private  volatile LocalDateTime  endTimeTranding; // время окончания торгов

    // "идея" подсвечивает переменную endTimeTranding и предлагает сделать её final
    // лично мне кажется это плохой идеей, так как возможно по некоторым причинам придётся передвинуть окончание торгов

    public Lot(long costOfLot , LocalDateTime endTimeTranding , String name){
        this.costOfLot = costOfLot; // при создании лота организаторами аукциона выставляется начальная цена
        this.endTimeTranding = endTimeTranding;
        currentName = name;
    }
    void setName(String name){
        currentName = name;
    }
    public void getData(){
        System.out.println(endTimeTranding);
    }
    public void setData(LocalDateTime date){
        endTimeTranding = date;
    }
    public  void placeBid(String name, long costOfLot){ // метод сделать ставку
        if(LocalDateTime.now().isBefore(endTimeTranding) && costOfLot > this.costOfLot){
            synchronized (this) { // синхронизируем по текущему объекту
                if(LocalDateTime.now().isBefore(endTimeTranding) && costOfLot > this.costOfLot){
                    this.currentName = name;
                    this.costOfLot = costOfLot;
                    System.out.println("Ставка прошла успешна");
                }
                else{
                    System.out.println("Your bid is less than the current one or the auction has already been completed");
                }
            }
        }
        else{
            System.out.println("Your bid is less than the current one or the auction has already been completed");
        }
    }

    public void getWinner(){ // получаем победителя
        /*
        if(LocalDateTime.now().isAfter(endTimeTranding)){
            System.out.println("The winner is " + currentName);
        }
        else{
            System.out.println("The auction is still going on");
        }
        */
        System.out.println(currentName);
    }

}
