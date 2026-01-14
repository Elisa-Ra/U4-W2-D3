package entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate,
                 List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order, id: " + id + " , status: " + status + " , data ordine: " + orderDate + ", data spedizione: "
                + deliveryDate + ", customer: " + customer.getName() + ", prodotti: " + products.size() + ".";
    }
}
