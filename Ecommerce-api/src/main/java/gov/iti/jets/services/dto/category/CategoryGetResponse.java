package gov.iti.jets.services.dto.category;

import gov.iti.jets.persistence.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryGetResponse {
    private int id;
    private String name;
    private List<CategoryProductGetResponse> products = new ArrayList<>();

    public CategoryGetResponse() {
    }

    public CategoryGetResponse( int id, String name, Set<Product> products ) {
        this.id = id;
        this.name = name;
        products.forEach( product -> {
            this.products.add( new CategoryProductGetResponse(product.getId(),product.getDescription(), product.getName() , product.getPrice()) );

        } );


    }

    public CategoryGetResponse( Integer id, String name ) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<CategoryProductGetResponse> getProducts() {
        return products;
    }

    public void setProducts( List<CategoryProductGetResponse> products ) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryGetResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
