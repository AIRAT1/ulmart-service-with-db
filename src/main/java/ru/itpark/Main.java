package ru.itpark;

import ru.itpark.domain.Order;
import ru.itpark.domain.Product;
import ru.itpark.domain.Sale;
import ru.itpark.domain.User;
import ru.itpark.util.JDBCTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Product> products = JDBCTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, name, category, quantity, status, price FROM products",
                rs -> new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getInt("quantity"),
                        rs.getInt("status"),
                        rs.getInt("price")
                        )
        );
        products.forEach(System.out::println);

        final List<User> users = JDBCTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, login, name FROM users",
                rs -> new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("name")
                )
        );
        users.forEach(System.out::println);

        final List<Order> orders = JDBCTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, quantity, product_name, product_price FROM orders",
                rs -> new Order(
                        rs.getInt("id"),
                        rs.getInt("quantity"),
                        rs.getString("product_name"),
                        rs.getInt("product_price")
                )
        );
        orders.forEach(System.out::println);

        final List<Sale> sales = JDBCTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, order_id, status FROM sales",
                rs -> new Sale(
                        rs.getInt("id"),
                        rs.getInt("order_id"),
                        rs.getInt("status")
                )
        );
        sales.forEach(System.out::println);
    }
}
