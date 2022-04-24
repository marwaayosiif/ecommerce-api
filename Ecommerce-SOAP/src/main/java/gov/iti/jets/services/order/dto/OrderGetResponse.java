package gov.iti.jets.services.order.dto;

import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OrderGetResponse {
    private Integer id;
    private OrderCustomerGetResponse customer;
    private Integer totalPrice;
    private List<OrderProductGetResponse> products = new ArrayList<>(0);

    public OrderGetResponse() {
    }

    public OrderGetResponse( Integer id, Customer customer, Integer totalPrice, Set<Product> products ) {
        this.id = id;
        this.customer = new OrderCustomerGetResponse(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone() );
        this.totalPrice = totalPrice;
        for ( Product product : products ) {
            this.products.add( new OrderProductGetResponse( product.getId(), product.getDescription(), product.getName(), product.getPrice()) );
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public OrderCustomerGetResponse getCustomer() {
        return customer;
    }

    public void setCustomer( OrderCustomerGetResponse customer ) {
        this.customer = customer;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice( Integer totalPrice ) {
        this.totalPrice = totalPrice;
    }

    public List<OrderProductGetResponse> getProducts() {
        return products;
    }

    public void setProducts( List<OrderProductGetResponse> products ) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderGetResponse{" +
                "id=" + id +
                ", customer=" + customer +
                ", totalPrice=" + totalPrice +
                ", products=" + products +
                '}';
    }
}
