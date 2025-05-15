package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Esercizio2 {
    public static void main(String[] args) {
        // Prodotti
        Product p1 = new Product(1L, "Ciuccio", "Baby", 15.0);
        Product p2 = new Product(2L, "Tuta", "Baby", 30.0);
        Product p3 = new Product(3L, "Peluche", "Toys", 20.0);

        // Clienti
        Customer c1 = new Customer(1L, "Luca", 2);
        Customer c2 = new Customer(2L, "Marco", 1);

        // Date
        LocalDate d1 = LocalDate.of(2021, 2, 5);
        LocalDate d2 = LocalDate.of(2021, 3, 10);
        LocalDate d3 = LocalDate.of(2021, 4, 10); // fuori range

        // Ordini
        Order o1 = new Order(101L, "Spedito", d1, d1.plusDays(3), List.of(p1, p2), c1); // dentro
        Order o2 = new Order(102L, "Spedito", d2, d2.plusDays(3), List.of(p3), c1);     // dentro
        Order o3 = new Order(103L, "Spedito", d3, d3.plusDays(3), List.of(p2), c2);     // fuori

        List<Order> orders = List.of(o1, o2, o3);

        Map<Customer, List<Order>> ordiniPerCliente = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        ordiniPerCliente.forEach((cliente, ordini) -> {
            System.out.println("Cliente: " + cliente.getName());
            ordini.forEach(System.out::println);
        });

    }
}