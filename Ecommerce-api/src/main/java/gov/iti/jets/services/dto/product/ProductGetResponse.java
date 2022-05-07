package gov.iti.jets.services.dto.product;

import gov.iti.jets.persistence.entity.Category;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@XmlRootElement
public class ProductGetResponse {
    private Integer id;
    private String description;
    private String name;
    private Integer price;
    private List<ProductCategoryGetResponse> categories = new ArrayList<>();
//    @XmlJavaTypeAdapter( Link.JaxbAdapter.class )
//    private List<Link> links = new ArrayList<>();

    public ProductGetResponse( Integer id, String description, String name, Integer price, Set<Category> categories ) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
        for ( Category category: categories ) {
            this.categories.add( new ProductCategoryGetResponse(category.getId(),category.getName()));
        }
    }

    public ProductGetResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
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

    public List<ProductCategoryGetResponse> getCategories() {
        return categories;
    }

    public void setCategories( List<ProductCategoryGetResponse> categories ) {
        this.categories = categories;
    }

//    public List<Link> getLinks() {
//        return links;
//    }
//
//    public void setLinks( List<Link> links ) {
//        this.links = links;
//    }

    @Override
    public String toString() {
        return "ProductGetResponse{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                '}';
    }
}
