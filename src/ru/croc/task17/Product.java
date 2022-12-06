package ru.croc.task17;

public class Product {
    private String article;
    private String nameProduct;
    private int price;

    public Product(String article, String nameProduct, int price) {
        this.article = article;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getPrice() {
        return price;
    }
}
