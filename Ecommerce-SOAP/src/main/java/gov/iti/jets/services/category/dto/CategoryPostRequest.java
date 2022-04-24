package gov.iti.jets.services.category.dto;

public class CategoryPostRequest {
    private String name;

    public CategoryPostRequest( String name ) {
        this.name = name;
    }

    public CategoryPostRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryPostRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
