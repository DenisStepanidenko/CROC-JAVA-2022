package ru.croc.task17;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    private DataSet data;

    public CreateTable(String pathToTheFile) throws IOException {
        this.data = new DataSet(pathToTheFile);
    }

    // создание таблицы заказов и продуктов
    public void createTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            //statement.execute("DROP TABLE Products");
            statement.execute("CREATE TABLE Products(" +
                    "ArticleId VARCHAR(255) PRIMARY KEY," +
                    "Product VARCHAR(255) NOT NULL," +
                    "Cost INT NOT NULL);"
            );
            statement.execute("CREATE TABLE Orders(" +
                    "Id INT NOT NULL," +
                    "UserName VARCHAR(255) NOT NULL," +
                    "Article VARCHAR(255)," +
                    "FOREIGN KEY(Article) REFERENCES Products(ArticleId) )"
            );
        }
    }
    // данный метод добавляет заказы в БД
    public void importOrders(Connection connection) throws SQLException {
        String request = "INSERT INTO Orders VALUES(?,?,?)";
        for(Order order : data.getOrders()){
            try(PreparedStatement statement = connection.prepareStatement(request)){
                statement.setInt(1 ,order.getId() );
                statement.setString(2, order.getUserName());
                statement.setString(3 , order.getArticle());
                statement.execute();
            }
        }
    }

    // данный метод добавляет продукты в БД
    public void importsProducts(Connection connection) throws SQLException {
        String request = "INSERT INTO Products VALUES(?,?,?)";
        for(Product product : data.getProducts()){
            try(PreparedStatement statement = connection.prepareStatement(request)){
                statement.setString(1 ,product.getArticle());
                statement.setString(2 , product.getNameProduct());
                statement.setInt(3 , product.getPrice());
                statement.execute();
            }
        }
    }

}
