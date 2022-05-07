package gov.iti.jets.services.dto.product;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductPostRequest {
    private String description;
    private String name;

    public ProductPostRequest( String description, String name ) {
        this.description = description;
        this.name = name;
    }

    public ProductPostRequest() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductPostRequest{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
