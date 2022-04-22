package gov.iti.jets.services.dto.admin;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AdminGetResponse {
    private int id;
    private String name;

    public AdminGetResponse( int id, String name ) {
        this.id = id;
        this.name = name;
    }

    public AdminGetResponse() {
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
        return "AdminGetResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
