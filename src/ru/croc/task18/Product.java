package ru.croc.task18;

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

    public void setArticle(String article) {
        this.article = article;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public Product() {

    }

    @Override // переопределяем для того, чтобы возвращать объект в виде информации о нём
    public String toString() {
        return "Product{" +
                "article='" + article + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }


}
