package ru.croc.task18;

import ru.croc.task18.exceptions.ThereIsNoSuchProductInDatabase;
import ru.croc.task18.exceptions.ThisProductAlreadyExists;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    // данный метод ищет продукт в базе данных
    Product findProduct(String productCode) throws SQLException {
        Product searchableProduct = new Product();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Products p WHERE p.ArticleId = ?")) {
            statement.setString(1, productCode);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                searchableProduct.setArticle(result.getString("ArticleId"));
                searchableProduct.setNameProduct(result.getString("Product"));
                searchableProduct.setPrice(result.getInt("Cost"));
            }
        }
        if (searchableProduct.getArticle() == null) { // здесь по факту можно запросить любую характеристику
            return null;
        } else {
            return searchableProduct;
        }
    }

    // данный метод создаёт продукт в БД
    Product createProduct(Product product) throws SQLException, ThisProductAlreadyExists {
        if (findProduct(product.getArticle()) != null) {
            throw new ThisProductAlreadyExists();
        } else {
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Products VALUES(?,?,?)")) {
                statement.setString(1, product.getArticle());
                statement.setString(2, product.getNameProduct());
                statement.setInt(3, product.getPrice());
                statement.execute();
            }
        }
        return product;
    }

    // данный метод обновляет информацию о товаре
    Product updateProduct(Product product) throws SQLException, ThereIsNoSuchProductInDatabase {
        // позаботимся о том, что продукта может и нет быть в таблице
        if (findProduct(product.getArticle()) == null) {
            throw new ThereIsNoSuchProductInDatabase();
        } else {
            String request = "UPDATE Products " +
                    "SET Product = ? , Cost = ?" +
                    "WHERE ArticleId = ?";
            try (PreparedStatement statement = connection.prepareStatement(request)) {
                statement.setString(1, product.getNameProduct());
                statement.setInt(2, product.getPrice());
                statement.setString(3, product.getArticle());
                statement.execute();
            }
        }
        return product;
    }

    // данный метод удаляет всю инфу о заказах с конкретным продуктом и сам продукт из базы
    void deleteProduct(String productCode) throws SQLException, ThereIsNoSuchProductInDatabase {
        // позаботимся о том, чтобы данный товар вообще был в базе
        if (findProduct(productCode) == null) {
            throw new ThereIsNoSuchProductInDatabase();
        } else {
            String request = "DELETE FROM Orders o " +
                    "WHERE o.Article = ?; " +
                    "DELETE FROM Products p " +
                    "WHERE p.ArticleId = ?";
            try (PreparedStatement statement = connection.prepareStatement(request)) {
                statement.setString(1, productCode);
                statement.setString(2, productCode);
                statement.execute();
            }
        }
    }

    // данный метод возвращает последний Id , который был задействован в таблице заказы
    int getLastId() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String request = "SELECT Id FROM Orders o ORDER BY o.Id DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(request);
            resultSet.next();
            return resultSet.getInt("Id");
        }
    }

    // данный метод создаёт заказ для конкретного пользователя
    Order createOrder(String userLogin, List<Product> products) throws SQLException, ThereIsNoSuchProductInDatabase {
        int id = getLastId() + 1;
        // в данный лист будет добавлять все артикулы товаров пользователя, который сделал заказ
        List<String> allArticle = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders VALUES(?,?,?)")) {
            for (Product product : products) {
                // позаботимся о том, что пользователь может заказать товар, которого нет в базе
                if (findProduct(product.getArticle()) == null) {
                    throw new ThereIsNoSuchProductInDatabase();
                }
                allArticle.add(product.getArticle());
                statement.setInt(1, id);
                statement.setString(2, userLogin);
                statement.setString(3, product.getArticle());
                statement.execute();
            }
        }
        return new Order(id, userLogin, allArticle);
    }


}
