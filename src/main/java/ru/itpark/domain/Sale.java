package ru.itpark.domain;

public class Sale {
    private int id;
    private int order_id;
    private int status;

    public Sale(int id, int order_id, int status) {
        this.id = id;
        this.order_id = order_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", status=" + status +
                '}';
    }
}
