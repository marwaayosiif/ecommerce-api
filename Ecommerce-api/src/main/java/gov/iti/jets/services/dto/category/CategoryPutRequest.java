package gov.iti.jets.services.dto.category;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class CategoryPutRequest {
    private String name;
    private List<Integer> productId = new ArrayList<>();

    public CategoryPutRequest( String name, List<Integer> productId ) {
        this.name = name;
        this.productId = productId;
    }

    public CategoryPutRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<Integer> getProductId() {
        return productId;
    }

    public void setProductId( List<Integer> productId ) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CategoryPutRequest{" +
                "name='" + name + '\'' +
                ", productId=" + productId +
                '}';
    }
}
