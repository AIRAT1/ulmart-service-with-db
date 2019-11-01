package ru.itpark.domain;

public class Product {
    private int id;
    private String category;
    private int quantity;
    private int status;
    private int price;

    public Product(int id, String category, int quantity, int availableToOrder, int price) {
        this.id = id;
        this.category = category;
        this.quantity = quantity;
        this.status = availableToOrder;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
