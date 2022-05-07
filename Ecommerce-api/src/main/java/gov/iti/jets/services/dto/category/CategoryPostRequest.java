package gov.iti.jets.services.dto.category;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
