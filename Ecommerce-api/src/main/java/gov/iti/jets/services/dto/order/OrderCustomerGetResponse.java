package gov.iti.jets.services.dto.order;

import gov.iti.jets.persistence.entity.Order;

import java.util.HashSet;
import java.util.Set;

public class OrderCustomerGetResponse {
    private Integer id;
    private String name;
    private String email;
    private String phone;

    public OrderCustomerGetResponse() {
    }

    public OrderCustomerGetResponse( Integer id, String name, String email, String phone ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "OrderCustomerGetResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}