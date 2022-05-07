package gov.iti.jets.services.dto.clerk;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClerkGetResponse {
    private int id;
    private String name;

    public ClerkGetResponse( int id, String name ) {
        this.id = id;
        this.name = name;
    }

    public ClerkGetResponse() {
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
        return "ClerksGetResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
