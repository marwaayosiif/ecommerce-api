package gov.iti.jets.services.customer.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderPostRequest {

    private Integer totalPrice;
    private List<Integer> productsId = new ArrayList<>();

    public CustomerOrderPostRequest( Integer totalPrice, List<Integer> productsId ) {
        this.totalPrice = totalPrice;
        this.productsId = productsId;
    }

    public CustomerOrderPostRequest() {
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice( Integer totalPrice ) {
        this.totalPrice = totalPrice;
    }

    public List<Integer> getProductsId() {
        return productsId;
    }

    public void setProductsId( List<Integer> productsId ) {
        this.productsId = productsId;
    }

    @Override
    public String toString() {
        return "CustomerOrderPostRequest{" +
                ", totalPrice=" + totalPrice +
                ", productsId=" + productsId +
                '}';
    }
}
