package gov.iti.jets.services.customer.dto;

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
