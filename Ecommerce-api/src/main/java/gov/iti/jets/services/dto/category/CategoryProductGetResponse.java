package gov.iti.jets.services.dto.category;

public class CategoryProductGetResponse {
    private Integer id;
    private String description;
    private String name;
    private Integer price;

    public CategoryProductGetResponse() {
    }

    public CategoryProductGetResponse( Integer id, String description, String name, Integer price ) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "ProductGetResponse{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
