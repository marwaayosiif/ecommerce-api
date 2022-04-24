package gov.iti.jets.services.dto.product;

public class ProductCategoryGetResponse {
    private int id;
    private String name;

    public ProductCategoryGetResponse( int id, String name ) {
        this.id = id;
        this.name = name;
    }

    public ProductCategoryGetResponse() {
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

    @Override
    public String toString() {
        return "ProductCategoryGetResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
