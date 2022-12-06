package ru.croc.task17;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Task17 {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        //String pathToFile = args[0];
        String path = "C:/Users/stepa/IdeaProjects/Croc/src/ru/croc/task17/data.csv";
        CreateTable test = new CreateTable(path);
        String connectionUrl = "jdbc:h2:tcp://localhost/~/test";
        String user = "sa";
        String password = "123";
        Connection connection = DriverManager.getConnection(connectionUrl , user , password);
        test.createTable(connection);
        test.importsProducts(connection);
        test.importOrders(connection);
        // тесты прошли успешно , всё загрузилось :)

    }
}
