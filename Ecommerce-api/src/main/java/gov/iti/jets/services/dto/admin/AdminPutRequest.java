package gov.iti.jets.services.dto.admin;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdminPutRequest {

    private String name;

    public AdminPutRequest() {
    }

    public AdminPutRequest( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdminPostRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
