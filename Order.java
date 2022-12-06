package ru.croc.task17;

public class Order {
    private int id;
    private String userName;
    private String article;

    public Order(int id, String userName, String article) {
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

    public String getArticle() {
        return article;
    }
}
