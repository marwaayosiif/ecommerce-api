package gov.iti.jets.services.dto.admin;

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
