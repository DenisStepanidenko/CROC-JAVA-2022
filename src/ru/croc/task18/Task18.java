package ru.croc.task18;

import ru.croc.task17.*;
import ru.croc.task18.exceptions.ThereIsNoSuchProductInDatabase;
import ru.croc.task18.exceptions.ThisProductAlreadyExists;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Task18 {
    public static void main(String[] args) throws IOException, SQLException, ThisProductAlreadyExists, ThereIsNoSuchProductInDatabase {
        // воспользуемся методами из 17 задачи и создадим таблицу, заполнив её данными из файла, который был в 17 задаче
        String path = "C:/Users/stepa/IdeaProjects/Croc/src/ru/croc/task17/data.csv";
        CreateTable test = new CreateTable(path);
        String connectionUrl = "jdbc:h2:tcp://localhost/~/test";
        String user = "sa";
        String password = "123";
        Connection connection = DriverManager.getConnection(connectionUrl, user, password);
        //test.createTable(connection);
        //test.importsProducts(connection);
        //test.importOrders(connection);

        // начинаем применять методы , написанные в 18 задаче
        Dao test2 = new Dao(connection);

        // сделаем поиск товара ( данный метод сработал , вывод - Product{article='Т2', nameProduct='Мышь', price=50} )
        //System.out.println(test2.findProduct("Т2")); //

        // создадим товар
        //test2.createProduct(new Product("T7" , "Процессор" , 35000));
        //System.out.println(test2.findProduct("T7"));

        // попробуем создать товар, который уже есть ( метод сработал и выбросил исключение )
        //test2.createProduct(new Product("T7" , "Мышка" , 4343));

        // обновим информацию о товаре ( данный метод сработал )
        //test2.updateProduct(new Product("Т3" , "Наушники" , 53454));
        //System.out.println(test2.findProduct("Т3"));

        // удалим продукт с конкретным артикулом ( данный метод тоже работает )
        //test2.deleteProduct("Т4");
        //System.out.println(test2.findProduct("Т4"));

        // попробуем создать заказ из продуктов, которых нет в базе данных ( метод сработал , вызвало исключение )
        //test2.createOrder("Denis" , new ArrayList<>(List.of(new Product("T9" , "Игровой комп" , 423435) , new Product("T10" , "Игровое кресло" , 434343))));

        // сделаем заказ для продуктов, котоыре есть в базе данных ( метод сработал - в базе данных показались все эти заказы )
        //test2.createOrder("Denis", new ArrayList<>(List.of(new Product("Т1", "Монитор", 500), new Product("Т2", "Мышь", 50))));
    }
}
