package gov.iti.jets.services.product.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductPutRequest {
    private String description;
    private String name;
    private Integer price;
    private List<Integer> categories = new ArrayList<>();

    public ProductPutRequest() {
    }

    public ProductPutRequest( String description, String name, Integer price, List<Integer> categories ) {
        this.description = description;
        this.name = name;
        this.price = price;
        this.categories = categories;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice( Integer price ) {
        this.price = price;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories( List<Integer> categories ) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "ProductPutRequest{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                '}';
    }
}
