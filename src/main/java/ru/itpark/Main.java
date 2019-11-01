package ru.itpark;

import ru.itpark.domain.Product;
import ru.itpark.util.JDBCTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Product> products = JDBCTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, category, quantity, status, price FROM products",
                rs -> new Product(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getInt("quantity"),
                        rs.getInt("status"),
                        rs.getInt("price")
                        )
        );
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
