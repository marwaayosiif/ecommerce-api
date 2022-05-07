package gov.iti.jets.services.dto.customer;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class CustomerGetResponse {
    private Integer id;
    private String name;
    private String email;
    private String phone;
//    @XmlJavaTypeAdapter( Link.JaxbAdapter.class )
    private List<String> links = new ArrayList<>();

    public CustomerGetResponse( Integer id, String name, String email, String phone ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public CustomerGetResponse() {
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

//    public List<Link> getLinks() {
//        return links;
//    }
//
//    public void setLinks( List<Link> links ) {
//        this.links = links;
//    }


    public List<String> getLinks() {
        return links;
    }

    public void setLinks( List<String> links ) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "CustomerGetResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
