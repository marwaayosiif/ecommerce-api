package gov.iti.jets.services.dto.customer;

import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Product;

import java.util.HashSet;
import java.util.Set;

public class CustomerOrderGetResponse {

    private Integer id;
    private Integer totalPrice;

    public CustomerOrderGetResponse() {
    }

    public CustomerOrderGetResponse( Integer id, Integer totalPrice ) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice( Integer totalPrice ) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CustomerOrderGetResponse{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
