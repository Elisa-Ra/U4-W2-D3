import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // PRODOTTI

        List<Product> products = List.of(
                new Product(1L, "Dracula", "Books", 150),
                new Product(2L, "Battle Royale", "Books", 84),
                new Product(3L, "Dinosauro gigante", "Boys", 200),
                new Product(4L, "Pallone", "Boys", 40),
                new Product(5L, "Biberon", "Baby", 15),
                new Product(6L, "Lucina da notte", "Baby", 25)
        );

        //  CLIENTI

        Customer c1 = new Customer(1L, "Elisa", 2);
        Customer c2 = new Customer(2L, "Pietro", 1);


        // ORDINI

        List<Order> orders = new ArrayList<>();

        orders.add(new Order(
                1L,
                "Shipped",
                LocalDate.of(2021, 2, 10),
                LocalDate.of(2021, 2, 15),
                List.of(products.get(0), products.get(2)), // Dracula + Dinosauro gigante
                c1
        ));

        orders.add(new Order(
                2L,
                "Delivered",
                LocalDate.of(2021, 3, 5),
                LocalDate.of(2021, 3, 10),
                List.of(products.get(4), products.get(5)), // Baby
                c2
        ));

        orders.add(new Order(
                3L,
                "Processing",
                LocalDate.of(2021, 4, 2),
                LocalDate.of(2021, 4, 8),
                List.of(products.get(1), products.get(3)), // Battle Royale + Pallone
                c1
        ));

        // ESERCIZIO 1: Ottenere una lista dei prodotti che appartengono alla categoria Books ed hanno un prezzo > 100

        System.out.println("\nEs 1: Libri con prezzo superiore a 100 euro:");
        List<Product> es1 = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .filter(p -> p.getPrice() > 100)
                .toList();
        es1.forEach(System.out::println);

        // ESERCIZIO 2: Ottenere una lista di ordini con prodotti che appartengono alla categoria Baby

        System.out.println("\nEs 2: Ordini con prodotti Baby:");
        List<Order> es2 = orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
                .toList();
        es2.forEach(System.out::println);

        // ESERCIZIO 3: Ottenere una lista di prodotti che appartengono alla categoria Boys e applicare 10%
        // di sconto al loro prezzo

        System.out.println("\nEs 3: Prodotti Boys con sconto 10%:");
        List<Product> es3 = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Boys"))
                .map(p -> new Product(
                        p.getId(),
                        p.getName(),
                        p.getCategory(),
                        p.getPrice() * 0.9
                ))
                .toList();
        es3.forEach(System.out::println);

        // ESERCIZIO 4: Ottenere una lista di prodotti ordinati da clienti di livello (tier) 2 tra l'1 febbraio 2021
        // e l'1 aprile 2021

        System.out.println("\nEs 4: Prodotti ordinati da clienti tier 2 tra 1 feb e 1 apr 2021:");

        LocalDate start = LocalDate.of(2021, 2, 1);
        LocalDate end = LocalDate.of(2021, 4, 1);

        List<Product> es4 = orders.stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> !o.getOrderDate().isBefore(start) &&
                        !o.getOrderDate().isAfter(end))
                .flatMap(o -> o.getProducts().stream())
                .toList();

        es4.forEach(System.out::println);
    }
}
