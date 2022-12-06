package ru.croc.task17;

import ru.croc.task13.recommendations.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataSet {
    private List<Order> orders;
    private List<Product> products;

    public DataSet(String pathToTheFile) throws IOException {
        orders = ru.croc.task17.Parser.parseOrders(pathToTheFile);
        products = ru.croc.task17.Parser.parseProducts(pathToTheFile);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Product> getProducts() {
        return products;
    }
}
