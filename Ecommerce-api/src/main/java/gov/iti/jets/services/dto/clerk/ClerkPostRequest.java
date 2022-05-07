package gov.iti.jets.services.dto.clerk;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClerkPostRequest {
    private String name;

    public ClerkPostRequest() {
    }

    public ClerkPostRequest( String name ) {
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
        return "ClerkPostRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
