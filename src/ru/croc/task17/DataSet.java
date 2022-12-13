package ru.croc.task17;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ru.croc.task17.Parser;
public class DataSet {
    private List<Order> orders;
    private List<Product> products;

    public DataSet(String pathToTheFile) throws IOException {
        orders = Parser.parseOrders(pathToTheFile);
        products = Parser.parseProducts(pathToTheFile);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Product> getProducts() {
        return products;
    }
}
