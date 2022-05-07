package gov.iti.jets.services.dto.customer;

import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Product;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement
public class CustomerOrderGetResponse {

    private Integer id;
    private Integer totalPrice;
//    @XmlJavaTypeAdapter( Link.JaxbAdapter.class )
//    private List<Link> links = new ArrayList<>();
    private List<String> link = new ArrayList<>();

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

//    public List<Link> getLinks() {
//        return links;
//    }
//
//    public void setLinks( List<Link> links ) {
//        this.links = links;
//    }


    public List<String> getLink() {
        return link;
    }

    public void setLink( List<String> link ) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "CustomerOrderGetResponse{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
