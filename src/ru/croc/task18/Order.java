package ru.croc.task18;

import java.util.List;

public class Order {
    private int id;
    private String userName;
    private List<String> article;

    public Order(int id, String userName, List<String> article) {
        this.id = id;
        this.userName = userName;
        this.article = article;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public List<String> getArticle() {
        return article;
    }
}


